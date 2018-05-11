package com.ictp.prayatna.nutrifinder.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by prayatna on 29/09/16.
 */
public class FoodNutrition {

        @SerializedName("old_api_id")
        @Expose
        private String oldApiId;

        @SerializedName("item_id")
        @Expose
        private String itemId;

        @SerializedName("item_name")
        @Expose
        private String itemName;

        @SerializedName("leg_loc_id")
        @Expose
        private String legLocId;

        @SerializedName("brand_id")
        @Expose
        private String brandId;

        @SerializedName("brand_name")
        @Expose
        private String brandName;

        @SerializedName("item_description")
        @Expose
        private String itemDescription;

        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        @SerializedName("nf_ingredient_statement")
        @Expose
        private String nfIngredientStatement;

        @SerializedName("nf_water_grams")
        @Expose
        private String nfWaterGrams;

        @SerializedName("nf_calories")
        @Expose
        private String nfCalories;

        @SerializedName("nf_calories_from_fat")
        @Expose
        private String nfCaloriesFromFat;

        @SerializedName("nf_total_fat")
        @Expose
        private String nfTotalFat;

        @SerializedName("nf_saturated_fat")
        @Expose
        private String nfSaturatedFat;

        @SerializedName("nf_trans_fatty_acid")
        @Expose
        private String nfTransFattyAcid;

        @SerializedName("nf_polyunsaturated_fat")
        @Expose
        private String nfPolyunsaturatedFat;

        @SerializedName("nf_monounsaturated_fat")
        @Expose
        private String nfMonounsaturatedFat;

        @SerializedName("nf_cholesterol")
        @Expose
        private String nfCholesterol;

        @SerializedName("nf_sodium")
        @Expose
        private String nfSodium;

        @SerializedName("nf_total_carbohydrate")
        @Expose
        private String nfTotalCarbohydrate;

        @SerializedName("nf_dietary_fiber")
        @Expose
        private String nfDietaryFiber;

        @SerializedName("nf_sugars")
        @Expose
        private String nfSugars;

        @SerializedName("nf_protein")
        @Expose
        private String nfProtein;

        @SerializedName("nf_vitamin_a_dv")
        @Expose
        private String nfVitaminADv;

        @SerializedName("nf_vitamin_c_dv")
        @Expose
        private String nfVitaminCDv;

        @SerializedName("nf_calcium_dv")
        @Expose
        private String nfCalciumDv;
        @SerializedName("nf_iron_dv")
        @Expose
        private String nfIronDv;

        @SerializedName("nf_refuse_pct")
        @Expose
        private String nfRefusePct;

        @SerializedName("nf_servings_per_container")
        @Expose
        private String nfServingsPerContainer;

        @SerializedName("nf_serving_size_qty")
        @Expose
        private String nfServingSizeQty;

        @SerializedName("nf_serving_size_unit")
        @Expose
        private String nfServingSizeUnit;

        @SerializedName("nf_serving_weight_grams")
        @Expose
        private String nfServingWeightGrams;


        /**
         *
         * @return
         * The oldApiId
         */
        public String getOldApiId() {
            return oldApiId;
        }

        /**
         *
         * @param oldApiId
         * The old_api_id
         */
        public void setOldApiId(String oldApiId) {
            this.oldApiId = oldApiId;
        }

        /**
         *
         * @return
         * The itemId
         */
        public String getItemId() {
            return itemId;
        }

        /**
         *
         * @param itemId
         * The item_id
         */
        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        /**
         *
         * @return
         * The itemName
         */
        public String getItemName() {
            return itemName;
        }

        /**
         *
         * @param itemName
         * The item_name
         */
        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        /**
         *
         * @return
         * The legLocId
         */
        public String getLegLocId() {
            return legLocId;
        }

        /**
         *
         * @param legLocId
         * The leg_loc_id
         */
        public void setLegLocId(String legLocId) {
            this.legLocId = legLocId;
        }

        /**
         *
         * @return
         * The brandId
         */
        public String getBrandId() {
            return brandId;
        }

        /**
         *
         * @param brandId
         * The brand_id
         */
        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        /**
         *
         * @return
         * The brandName
         */
        public String getBrandName() {
            return brandName;
        }

        /**
         *
         * @param brandName
         * The brand_name
         */
        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        /**
         *
         * @return
         * The itemDescription
         */
        public String getItemDescription() {
            return itemDescription;
        }

        /**
         *
         * @param itemDescription
         * The item_description
         */
        public void setItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
        }

        /**
         *
         * @return
         * The updatedAt
         */
        public String getUpdatedAt() {
            return updatedAt;
        }

        /**
         *
         * @param updatedAt
         * The updated_at
         */
        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        /**
         *
         * @return
         * The nfIngredientStatement
         */
        public String getNfIngredientStatement() {
            return nfIngredientStatement;
        }

        /**
         *
         * @param nfIngredientStatement
         * The nf_ingredient_statement
         */
        public void setNfIngredientStatement(String nfIngredientStatement) {
            this.nfIngredientStatement = nfIngredientStatement;
        }

        /**
         *
         * @return
         * The nfWaterGrams
         */
        public String getNfWaterGrams() {
            return nfWaterGrams;
        }

        /**
         *
         * @param nfWaterGrams
         * The nf_water_grams
         */
        public void setNfWaterGrams(String nfWaterGrams) {
            this.nfWaterGrams = nfWaterGrams;
        }

        /**
         *
         * @return
         * The nfCalories
         */
        public String getNfCalories() {
            return nfCalories;
        }

        /**
         *
         * @param nfCalories
         * The nf_calories
         */
        public void setNfCalories(String nfCalories) {
            this.nfCalories = nfCalories;
        }

        /**
         *
         * @return
         * The nfCaloriesFromFat
         */
        public String getNfCaloriesFromFat() {
            return nfCaloriesFromFat;
        }

        /**
         *
         * @param nfCaloriesFromFat
         * The nf_calories_from_fat
         */
        public void setNfCaloriesFromFat(String nfCaloriesFromFat) {
            this.nfCaloriesFromFat = nfCaloriesFromFat;
        }

        /**
         *
         * @return
         * The nfTotalFat
         */
        public String getNfTotalFat() {
            return nfTotalFat;
        }

        /**
         *
         * @param nfTotalFat
         * The nf_total_fat
         */
        public void setNfTotalFat(String nfTotalFat) {
            this.nfTotalFat = nfTotalFat;
        }

        /**
         *
         * @return
         * The nfSaturatedFat
         */
        public String getNfSaturatedFat() {
            return nfSaturatedFat;
        }

        /**
         *
         * @param nfSaturatedFat
         * The nf_saturated_fat
         */
        public void setNfSaturatedFat(String nfSaturatedFat) {
            this.nfSaturatedFat = nfSaturatedFat;
        }

        /**
         *
         * @return
         * The nfTransFattyAcid
         */
        public String getNfTransFattyAcid() {
            return nfTransFattyAcid;
        }

        /**
         *
         * @param nfTransFattyAcid
         * The nf_trans_fatty_acid
         */
        public void setNfTransFattyAcid(String nfTransFattyAcid) {
            this.nfTransFattyAcid = nfTransFattyAcid;
        }

        /**
         *
         * @return
         * The nfPolyunsaturatedFat
         */
        public String getNfPolyunsaturatedFat() {
            return nfPolyunsaturatedFat;
        }

        /**
         *
         * @param nfPolyunsaturatedFat
         * The nf_polyunsaturated_fat
         */
        public void setNfPolyunsaturatedFat(String nfPolyunsaturatedFat) {
            this.nfPolyunsaturatedFat = nfPolyunsaturatedFat;
        }

        /**
         *
         * @return
         * The nfMonounsaturatedFat
         */
        public String getNfMonounsaturatedFat() {
            return nfMonounsaturatedFat;
        }

        /**
         *
         * @param nfMonounsaturatedFat
         * The nf_monounsaturated_fat
         */
        public void setNfMonounsaturatedFat(String nfMonounsaturatedFat) {
            this.nfMonounsaturatedFat = nfMonounsaturatedFat;
        }

        /**
         *
         * @return
         * The nfCholesterol
         */
        public String getNfCholesterol() {
            return nfCholesterol;
        }

        /**
         *
         * @param nfCholesterol
         * The nf_cholesterol
         */
        public void setNfCholesterol(String nfCholesterol) {
            this.nfCholesterol = nfCholesterol;
        }

        /**
         *
         * @return
         * The nfSodium
         */
        public String getNfSodium() {
            return nfSodium;
        }

        /**
         *
         * @param nfSodium
         * The nf_sodium
         */
        public void setNfSodium(String nfSodium) {
            this.nfSodium = nfSodium;
        }

        /**
         *
         * @return
         * The nfTotalCarbohydrate
         */
        public String getNfTotalCarbohydrate() {
            return nfTotalCarbohydrate;
        }

        /**
         *
         * @param nfTotalCarbohydrate
         * The nf_total_carbohydrate
         */
        public void setNfTotalCarbohydrate(String nfTotalCarbohydrate) {
            this.nfTotalCarbohydrate = nfTotalCarbohydrate;
        }

        /**
         *
         * @return
         * The nfDietaryFiber
         */
        public String getNfDietaryFiber() {
            return nfDietaryFiber;
        }

        /**
         *
         * @param nfDietaryFiber
         * The nf_dietary_fiber
         */
        public void setNfDietaryFiber(String nfDietaryFiber) {
            this.nfDietaryFiber = nfDietaryFiber;
        }

        /**
         *
         * @return
         * The nfSugars
         */
        public String getNfSugars() {
            return nfSugars;
        }

        /**
         *
         * @param nfSugars
         * The nf_sugars
         */
        public void setNfSugars(String nfSugars) {
            this.nfSugars = nfSugars;
        }

        /**
         *
         * @return
         * The nfProtein
         */
        public String getNfProtein() {
            return nfProtein;
        }

        /**
         *
         * @param nfProtein
         * The nf_protein
         */
        public void setNfProtein(String nfProtein) {
            this.nfProtein = nfProtein;
        }

        /**
         *
         * @return
         * The nfVitaminADv
         */
        public String getNfVitaminADv() {
            return nfVitaminADv;
        }

        /**
         *
         * @param nfVitaminADv
         * The nf_vitamin_a_dv
         */
        public void setNfVitaminADv(String nfVitaminADv) {
            this.nfVitaminADv = nfVitaminADv;
        }

        /**
         *
         * @return
         * The nfVitaminCDv
         */
        public String getNfVitaminCDv() {
            return nfVitaminCDv;
        }

        /**
         *
         * @param nfVitaminCDv
         * The nf_vitamin_c_dv
         */
        public void setNfVitaminCDv(String nfVitaminCDv) {
            this.nfVitaminCDv = nfVitaminCDv;
        }

        /**
         *
         * @return
         * The nfCalciumDv
         */
        public String getNfCalciumDv() {
            return nfCalciumDv;
        }

        /**
         *
         * @param nfCalciumDv
         * The nf_calcium_dv
         */
        public void setNfCalciumDv(String nfCalciumDv) {
            this.nfCalciumDv = nfCalciumDv;
        }

        /**
         *
         * @return
         * The nfIronDv
         */
        public String getNfIronDv() {
            return nfIronDv;
        }

        /**
         *
         * @param nfIronDv
         * The nf_iron_dv
         */
        public void setNfIronDv(String nfIronDv) {
            this.nfIronDv = nfIronDv;
        }

        /**
         *
         * @return
         * The nfRefusePct
         */
        public String getNfRefusePct() {
            return nfRefusePct;
        }

        /**
         *
         * @param nfRefusePct
         * The nf_refuse_pct
         */
        public void setNfRefusePct(String nfRefusePct) {
            this.nfRefusePct = nfRefusePct;
        }

        /**
         *
         * @return
         * The nfServingsPerContainer
         */
        public String getNfServingsPerContainer() {
            return nfServingsPerContainer;
        }

        /**
         *
         * @param nfServingsPerContainer
         * The nf_servings_per_container
         */
        public void setNfServingsPerContainer(String nfServingsPerContainer) {
            this.nfServingsPerContainer = nfServingsPerContainer;
        }

        /**
         *
         * @return
         * The nfServingSizeQty
         */
        public String getNfServingSizeQty() {
            return nfServingSizeQty;
        }

        /**
         *
         * @param nfServingSizeQty
         * The nf_serving_size_qty
         */
        public void setNfServingSizeQty(String nfServingSizeQty) {
            this.nfServingSizeQty = nfServingSizeQty;
        }

        /**
         *
         * @return
         * The nfServingSizeUnit
         */
        public String getNfServingSizeUnit() {
            return nfServingSizeUnit;
        }

        /**
         *
         * @param nfServingSizeUnit
         * The nf_serving_size_unit
         */
        public void setNfServingSizeUnit(String nfServingSizeUnit) {
            this.nfServingSizeUnit = nfServingSizeUnit;
        }

        /**
         *
         * @return
         * The nfServingWeightGrams
         */
        public String getNfServingWeightGrams() {
            return nfServingWeightGrams;
        }

        /**
         *
         * @param nfServingWeightGrams
         * The nf_serving_weight_grams
         */
        public void setNfServingWeightGrams(String nfServingWeightGrams) {
            this.nfServingWeightGrams = nfServingWeightGrams;
        }



    }


