
package com.example.saurabh.weatherapp.pojoclass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Results {

    @SerializedName("channel")
    @Expose
    public Channel channel;

}
