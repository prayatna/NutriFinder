package com.ictp.prayatna.nutrifinder.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by prayatna on 29/09/16.
 */
public class Fields {

    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("brand_id")
    @Expose
    private String brandId;
    @SerializedName("brand_name")
    @Expose
    private String brandName;
    @SerializedName("nf_serving_size_qty")
    @Expose
    private int nfServingSizeQty;
    @SerializedName("nf_serving_size_unit")
    @Expose
    private String nfServingSizeUnit;

    /**
     * @return The itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId The item_id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * @return The itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName The item_name
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return The brandId
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * @param brandId The brand_id
     */
    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    /**
     * @return The brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * @param brandName The brand_name
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * @return The nfServingSizeQty
     */
    public int getNfServingSizeQty() {
        return nfServingSizeQty;
    }

    /**
     * @param nfServingSizeQty The nf_serving_size_qty
     */
    public void setNfServingSizeQty(int nfServingSizeQty) {
        this.nfServingSizeQty = nfServingSizeQty;
    }

    /**
     * @return The nfServingSizeUnit
     */
    public String getNfServingSizeUnit() {
        return nfServingSizeUnit;
    }

    /**
     * @param nfServingSizeUnit The nf_serving_size_unit
     */
    public void setNfServingSizeUnit(String nfServingSizeUnit) {
        this.nfServingSizeUnit = nfServingSizeUnit;
    }
}
