package com.ictp.prayatna.nutrifinder;

import com.ictp.prayatna.nutrifinder.model.NutritionixItem;
import com.ictp.prayatna.nutrifinder.model.FoodNutrition;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by prayatna on 29/09/16.
 */
public interface NutritionixAPI {
    String ENDPOINT = "https://api.nutritionix.com/v1_1/";

    @GET("search/{itemName}?results=0%3A1")
    Call<NutritionixItem> getItemName(@Path("itemName") String itemName, @Query("appId") String appId, @Query("appKey") String appKey);


    @GET("item?")
    Call<FoodNutrition> getNutrition(@Query("id") String id, @Query("appId") String appId, @Query("appKey") String appKey);
}
