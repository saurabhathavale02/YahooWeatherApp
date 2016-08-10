package com.example.saurabh.weatherapp.custominterface;

import com.example.saurabh.weatherapp.pojoclass.WeatherClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by saurabh on 08/09/16.
 */
public interface WeatherInterface
{
    @GET("v1/public/yql")
    Call<WeatherClass> getWeatherReport(@Query("q") String param1,
                                        @Query("format") String param2,
                                       @Query("env") String param3);


}
