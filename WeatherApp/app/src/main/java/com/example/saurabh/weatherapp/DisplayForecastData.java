package com.example.saurabh.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.saurabh.weatherapp.pojoclass.Forecast;

public class DisplayForecastData extends AppCompatActivity
{

    TextView day,date,high,low,text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_forecast_data);

        day=(TextView) findViewById(R.id.day);
        date=(TextView) findViewById(R.id.date);
        high=(TextView) findViewById(R.id.high);
        low=(TextView) findViewById(R.id.low);
        text=(TextView) findViewById(R.id.text);

        Intent intent = this.getIntent();

        //Get Serialize data
        Forecast f= (Forecast)intent.getSerializableExtra("selectedforecast");

        //Populate the view

        day.setText("DAY-:"+f.day);
        date.setText("DATE-:"+f.date);
        high.setText("HIGH-:"+f.high+" F");
        low.setText("LOW-:"+f.low+" F");
        text.setText("Weather-:"+f.text);
    }

    public void onBackPressed()
    {
        finish();
    }
}
