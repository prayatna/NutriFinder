package com.ictp.prayatna.nutrifinder;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.clarifai.api.ClarifaiClient;
import com.clarifai.api.RecognitionRequest;
import com.clarifai.api.RecognitionResult;
import com.clarifai.api.Tag;
import com.clarifai.api.exception.ClarifaiException;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static android.R.id.list;
import static com.ictp.prayatna.nutrifinder.R.drawable.logo2;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private final ClarifaiClient client = new ClarifaiClient(Credentials.CLIENT_ID,
            Credentials.CLIENT_SECRET);
    private static final int CODE_PICK = 1;
    private static final int ACTIVITY_START_CAM = 0;
    public static String foodName;
    public static String foodProbs;
    private ImageButton selectImage;
    private ImageButton takePicture;
    private ImageView imageView;
    private TextView textView;
    public static Bitmap foodPic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image_view);
        textView = (TextView) findViewById(R.id.text_view);
        selectImage = (ImageButton) findViewById(R.id.select_image);
        takePicture = (ImageButton) findViewById(R.id.take_picture);
        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Send an intent to launch the media picker.
                final Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, CODE_PICK);
            }
        });
        takePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture(v);
            }

        });


    }

    public void takePicture(View view) {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, ACTIVITY_START_CAM);

    }

    //TODO: Create single method for asyncTask
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTIVITY_START_CAM && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap photoCaptured = (Bitmap) extras.get("data");
            foodPic = photoCaptured;
            if (photoCaptured != null) {
                textView.setText("Recognizing...");
                // Run recognition on a background thread since it makes a network call.
                new AsyncTask<Bitmap, Void, RecognitionResult>() {
                    @Override
                    protected RecognitionResult doInBackground(Bitmap... bitmaps) {
                        return recognizeBitmap(bitmaps[0]);
                    }

                    @Override
                    protected void onPostExecute(RecognitionResult result) {
                        List<Tag> test = result.getTags();
                        String name;
                        double probs;

                        Tag a = test.get(0);
                        name = a.getName();
                        probs = a.getProbability();

                        foodName = name;
                        foodProbs = String.valueOf(probs);

                        updateUIForResult(result);
                        passIdentifiedPhotoIntent();
                    }

                }.execute(photoCaptured);
            }
            imageView.setImageBitmap(photoCaptured);

        }

        if (requestCode == CODE_PICK && resultCode == RESULT_OK) {
            // The user picked an image. Send it to Clarifai for recognition.
            Log.d(TAG, "User picked image: " + data.getData());
            Bitmap bitmap = loadBitmapFromUri(data.getData());
            foodPic = bitmap;
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                textView.setText("Recognizing...");
                selectImage.setEnabled(false);

                // Run recognition on a background thread since it makes a network call.
                new AsyncTask<Bitmap, Void, RecognitionResult>() {
                    @Override
                    protected RecognitionResult doInBackground(Bitmap... bitmaps) {
                        return recognizeBitmap(bitmaps[0]);
                    }

                    @Override
                    protected void onPostExecute(RecognitionResult result) {
                        List<Tag> test = result.getTags();
                        String name;
                        double probs;

                        Tag first = test.get(0);
                        name = first.getName();
                        probs = first.getProbability();

                        foodName = name;
                        foodProbs = String.valueOf(probs);
                        updateUIForResult(result);
                        passIdentifiedPhotoIntent();
                    }
                }.execute(bitmap);
            } else {
                textView.setText("Unable to load selected image.");
            }
        }

    }


    /**
     * Loads a Bitmap from a content URI returned by the media picker.
     */
    private Bitmap loadBitmapFromUri(Uri uri) {
        try {
            // The image may be large. Load an image that is sized for display. This follows best
            // practices from http://developer.android.com/training/displaying-bitmaps/load-bitmap.html
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, opts);
            int sampleSize = 1;
            while (opts.outWidth / (2 * sampleSize) >= imageView.getWidth() &&
                    opts.outHeight / (2 * sampleSize) >= imageView.getHeight()) {
                sampleSize *= 2;
            }

            opts = new BitmapFactory.Options();
            opts.inSampleSize = sampleSize;
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, opts);
        } catch (IOException e) {
            Log.e(TAG, "Error loading image: " + uri, e);
        }
        return null;
    }


    /**
     * Sends the given bitmap to Clarifai for recognition and returns the result.
     */
    private RecognitionResult recognizeBitmap(Bitmap bitmap) {
        try {
            // Scale down the image. This step is optional. However, sending large images over the
            // network is slow and  does not significantly improve recognition performance.
            Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 320,
                    320 * bitmap.getHeight() / bitmap.getWidth(), true);

            // Compress the image as a JPEG.
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            scaled.compress(Bitmap.CompressFormat.JPEG, 90, out);
            byte[] jpeg = out.toByteArray();

            // Send the JPEG to Clarifai and return the result.
            return client.recognize(new RecognitionRequest(jpeg)).get(0);
        } catch (ClarifaiException e) {
            Log.e(TAG, "Clarifai error", e);
            return null;
        }
    }

    /**
     * Updates the UI by displaying tags for the given result.
     */
    private void updateUIForResult(RecognitionResult result) {
        if (result != null) {
            if (result.getStatusCode() == RecognitionResult.StatusCode.OK) {
                // Display the list of tags in the UI.
                StringBuilder b = new StringBuilder();
                for (Tag tag : result.getTags()) {
                    b.append(b.length() > 0 ? ", " : "").append(tag.getName());
                }
                textView.setText("Tags:\n" + b);
            } else {
                Log.e(TAG, "Clarifai: " + result.getStatusMessage());
                textView.setText("Sorry, there was an error recognizing your image.");
            }
        } else {
            textView.setText("Sorry, there was an error recognizing your image.");
        }
        selectImage.setEnabled(true);

    }

    //method/intent to call Nutritionix call and take the activity to another intent
    public void passIdentifiedPhotoIntent() {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), NutritionixCall.class);
        startActivity(intent);
    }
}
