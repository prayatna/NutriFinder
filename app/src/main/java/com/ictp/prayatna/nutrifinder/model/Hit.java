package com.ictp.prayatna.nutrifinder.model;

/**
 * Created by prayatna on 29/09/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Hit {

    @SerializedName("_index")
    @Expose
    private String index;

    @SerializedName("_type")
    @Expose
    private String type;

    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("_score")
    @Expose
    private float score;

    @SerializedName("fields")
    @Expose
    private Fields fields;

    /**
     * @return The index
     */
    public String getIndex() {
        return index;
    }

    /**
     * @param index The _index
     */
    public void setIndex(String index) {
        this.index = index;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The _type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The _id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The score
     */
    public float getScore() {
        return score;
    }

    /**
     * @param score The _score
     */
    public void setScore(float score) {
        this.score = score;
    }

    /**
     * @return The fields
     */
    public Fields getFields() {
        return fields;
    }

    /**
     * @param fields The fields
     */
    public void setFields(Fields fields) {
        this.fields = fields;
    }

}

