package com.ictp.prayatna.nutrifinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ictp.prayatna.nutrifinder.model.FoodNutrition;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NutritionInfo extends AppCompatActivity implements Callback<FoodNutrition> {
    public static String totalCalories;
    public static String caloriesFromFat;
    public static String totalFat;
    public static String saturatedFat;
    public static String transFat;
    public static String cholestoral;
    public static String sodium;
    public static String totalCarb;
    public static String dietaryFiber;
    public static String sugars;
    public static String protein;
    public static String vitaminA;
    public static String vitaminC;
    public static String iron;
    public static String calcium;
    public static String quantity;
    public static String unit;
    public static String weight;
    public static String foodName;

    private String PERCENT = "%";
    private String MG = "mg";
    private String G = "g";
    private String KCAL = "KCal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Click on Actionbar Info Icon for more details", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Credentials nutriCredientials = new Credentials();
        String appId = nutriCredientials.NUTRI_ID;
        String appKey = nutriCredientials.NUTRI_KEY;

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NutritionixAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        String id = NutritionixCall.itemId;
        NutritionixAPI nutrionixAPI = retrofit.create(NutritionixAPI.class);
        Call<FoodNutrition> call = nutrionixAPI.getNutrition(id, appId, appKey);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<FoodNutrition> call, Response<FoodNutrition> response) {
        int code = response.code();

        if (code == 200) {
            FoodNutrition item = response.body();
            totalCalories = item.getNfCalories() + KCAL;
            caloriesFromFat = item.getNfCaloriesFromFat();
            totalFat = item.getNfTotalFat() + G;
            saturatedFat = item.getNfSaturatedFat() + G;
            transFat = item.getNfTransFattyAcid() + G;
            cholestoral = item.getNfCholesterol() + MG;
            sodium = item.getNfSodium() + MG;
            totalCarb = item.getNfTotalCarbohydrate() + G;
            dietaryFiber = item.getNfDietaryFiber() + G;
            sugars = item.getNfSugars() + G;
            protein = item.getNfProtein() + G;
            vitaminA = item.getNfVitaminADv() + PERCENT;
            vitaminC = item.getNfVitaminCDv() + PERCENT;
            iron = item.getNfIronDv() + PERCENT;
            calcium = item.getNfCalciumDv() + PERCENT;
            quantity = item.getNfServingSizeQty();
            unit = item.getNfServingSizeUnit();
            weight = item.getNfServingWeightGrams() + G;
            foodName = item.getItemName();


//            setContentView(R.layout.content_nutrition_info);


            TextView foodNameV = (TextView) findViewById(R.id.viewFoodName);
            foodNameV.setText(MainActivity.foodName);

            TextView weightV = (TextView) findViewById(R.id.viewWeight);
            weightV.setText(weight);
            TextView unitV = (TextView) findViewById(R.id.viewUnit);
//            unitV.setText(unit);

            TextView calories = (TextView) findViewById(R.id.viewCalorie);
            calories.setText(totalCalories);


//        TextView caloriesFFat = (TextView)findViewById(R.id.view);
//        calories.setText(caloriesFromFatS);

            TextView fats = (TextView) findViewById(R.id.viewTotalFat);
            fats.setText(totalFat);
            TextView sFat = (TextView) findViewById(R.id.viewSaturatedFat);
            sFat.setText(saturatedFat);
            TextView tFat = (TextView) findViewById(R.id.viewTransFat);
            tFat.setText(transFat);
            TextView cholestoralT = (TextView) findViewById(R.id.viewCholesterolAmt);
            cholestoralT.setText(cholestoral);
            TextView sodiumT = (TextView) findViewById(R.id.viewSodiumAmount);
            sodiumT.setText(sodium);
            TextView carb = (TextView) findViewById(R.id.viewTotalCarb);
            carb.setText(totalCarb);
            TextView dFiber = (TextView) findViewById(R.id.viewDietaryFiber);
            dFiber.setText(dietaryFiber);
            TextView sugarT = (TextView) findViewById(R.id.viewSugars);
            sugarT.setText(sugars);
            TextView proteinT = (TextView) findViewById(R.id.viewTotalProtein);
            proteinT.setText(protein);
            TextView vitaminAT = (TextView) findViewById(R.id.viewVitaminA);
            vitaminAT.setText(vitaminA);
            TextView vitaminCT = (TextView) findViewById(R.id.viewVitaminC);
            vitaminCT.setText(vitaminC);
            TextView calciumT = (TextView) findViewById(R.id.viewCalcium);
            calciumT.setText(calcium);
            TextView ironT = (TextView) findViewById(R.id.viewIron);
            ironT.setText(iron);

        }
    }

    @Override
    public void onFailure(Call<FoodNutrition> call, Throwable t) {
        Toast.makeText(this, "Nope" + t, Toast.LENGTH_LONG).show();

    }

    public void startOver(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_contact) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
