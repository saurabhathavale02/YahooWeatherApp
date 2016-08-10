
package com.example.saurabh.weatherapp.pojoclass;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Query {

    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("created")
    @Expose
    public String created;
    @SerializedName("lang")
    @Expose
    public String lang;
    @SerializedName("results")
    @Expose
    public Results results;

}
