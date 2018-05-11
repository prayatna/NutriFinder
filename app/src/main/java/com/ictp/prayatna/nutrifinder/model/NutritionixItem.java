package com.ictp.prayatna.nutrifinder.model;

/**
 * Created by prayatna on 29/09/16.
 */
// Class for initial call to search an item and get its id for later use.

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NutritionixItem {

    @SerializedName("total_hits")
    @Expose
    private int totalHits;
    @SerializedName("max_score")
    @Expose
    private double maxScore;
    @SerializedName("hits")
    @Expose
    private List<Hit> hits = new ArrayList<>();

    /**
     * @return The totalHits
     */
    public int getTotalHits() {
        return totalHits;
    }

    /**
     * @param totalHits The total_hits
     */
    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    /**
     * @return The maxScore
     */
    public double getMaxScore() {
        return maxScore;
    }

    /**
     * @param maxScore The max_score
     */
    public void setMaxScore(float maxScore) {
        this.maxScore = maxScore;
    }

    /**
     * @return The hits
     */
    public List<Hit> getHits() {
        return hits;
    }

    /**
     * @param hits The hits
     */
    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }
}


