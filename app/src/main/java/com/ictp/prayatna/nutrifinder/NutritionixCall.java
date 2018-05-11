package com.ictp.prayatna.nutrifinder;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ictp.prayatna.nutrifinder.model.Hit;
import com.ictp.prayatna.nutrifinder.model.NutritionixItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NutritionixCall extends AppCompatActivity implements Callback<NutritionixItem> {
    public static String itemId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String foodName = MainActivity.foodName;
        Bitmap foodPic = MainActivity.foodPic;
        setContentView(R.layout.activity_nutritionix_call);

        TextView foodNameView = (TextView) findViewById(R.id.foodNameView);
        foodNameView.setText(foodName);

        ImageView foodPicture = (ImageView) findViewById(R.id.foodBitmap);
        foodPicture.setImageBitmap(foodPic);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NutritionixAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        Credentials nutriCredientials = new Credentials();
        String appId = nutriCredientials.NUTRI_ID;
        String appKey = nutriCredientials.NUTRI_KEY;

        NutritionixAPI nutrionixAPI = retrofit.create(NutritionixAPI.class);
        Call<NutritionixItem> call = nutrionixAPI.getItemName(foodName, appId, appKey);
        call.enqueue(this);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(NutritionixCall.this, NutritionInfo.class));
                finish();
            }
        }, 4000);
    }


    @Override
    public void onResponse(Call<NutritionixItem> call, Response<NutritionixItem> response) {
        int code = response.code();
        if (code == 200) {
            NutritionixItem item = response.body();
            List<Hit> hits = item.getHits();
            for (Hit hit : hits) {
                itemId = hit.getId();
            }

//            Toast.makeText(this, "Got total hits: " + item.getTotalHits(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Did not work: " + String.valueOf(code), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onFailure(Call<NutritionixItem> call, Throwable t) {
        Toast.makeText(this, "did not call api", Toast.LENGTH_LONG).show();

    }
}
