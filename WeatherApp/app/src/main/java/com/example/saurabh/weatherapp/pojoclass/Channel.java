
package com.example.saurabh.weatherapp.pojoclass;

import android.location.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Channel {


    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("language")
    @Expose
    public String language;
    @SerializedName("lastBuildDate")
    @Expose
    public String lastBuildDate;
    @SerializedName("ttl")
    @Expose
    public String ttl;
    @SerializedName("location")
    @Expose
    public Location location;
    @SerializedName("wind")
    @Expose
    public Wind wind;

    @SerializedName("item")
    @Expose
    public Item item;

}
