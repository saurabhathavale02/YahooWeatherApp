
package com.example.saurabh.weatherapp.pojoclass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Forecast implements Serializable
{

    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("day")
    @Expose
    public String day;
    @SerializedName("high")
    @Expose
    public String high;
    @SerializedName("low")
    @Expose
    public String low;
    @SerializedName("text")
    @Expose
    public String text;

}
