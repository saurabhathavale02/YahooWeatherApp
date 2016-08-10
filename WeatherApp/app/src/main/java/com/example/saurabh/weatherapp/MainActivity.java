package com.example.saurabh.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabh.weatherapp.adapter.WeatherAdapter;
import com.example.saurabh.weatherapp.custominterface.OnItemClickListener;
import com.example.saurabh.weatherapp.custominterface.WeatherInterface;
import com.example.saurabh.weatherapp.pojoclass.Forecast;
import com.example.saurabh.weatherapp.pojoclass.WeatherClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{


    String url= "https://query.yahooapis.com";
    String param2="json";
    String param3="store://datatables.org/alltableswithkeys";
    Retrofit retrofit;
    TextView CityName;
    ProgressBar pb;
    RecyclerView ForcastList;
    WeatherAdapter weatheradapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CityName=(TextView) findViewById(R.id.cityname);
        pb=(ProgressBar) findViewById(R.id.progressBar);
        ForcastList=(RecyclerView) findViewById(R.id.displayforcast);

        //Set Layout for Recycle view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        ForcastList.setLayoutManager(layoutManager);

        //Set Progreebar visible
        pb.setVisibility(View.VISIBLE);

        //Get Selcted city data
        Bundle b = new Bundle();
        b = getIntent().getExtras();
        String cityname = b.getString("selectedcity");

        CityName.setText(cityname+" Weather");

        //Generate query
        String param1= "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\""+cityname+"\")";

        //Create Service
        retrofit= new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherInterface service = retrofit.create(WeatherInterface.class);

        Call<WeatherClass> call =  service.getWeatherReport(param1, param2, param3);

        //Execute asynchronous call
        call.enqueue(new Callback<WeatherClass>() {

            @Override
            public void onResponse(Call<WeatherClass> call, final Response<WeatherClass> weatherClass) {
                Log.i("data=", "value=" + weatherClass.body().query.count);

                Integer forecasrsize = weatherClass.body().query.results.channel.item.forecast.size();

                //Populate Recycle View with forecast
                weatheradapter = new WeatherAdapter(weatherClass.body().query.results.channel.item.forecast);
                ForcastList.setAdapter(weatheradapter);

                pb.setVisibility(View.INVISIBLE);

                //On Recycle view item click

                weatheradapter.SetOnItemClickListener(new OnItemClickListener()
                {

                    @Override
                    public void onClick(View view, int position)
                    {
                        //Display Detail Page
                        Log.i("data","selected="+weatherClass.body().query.results.channel.item.forecast.get(position).day);
                        Intent i=new Intent(MainActivity.this,DisplayForecastData.class);

                        Forecast selectedforecast= weatherClass.body().query.results.channel.item.forecast.get(position);
                        i.putExtra("selectedforecast", selectedforecast);
                        startActivity(i);



                    }
                });

            }

            @Override
            public void onFailure(Call<WeatherClass> call, Throwable t) {

                Log.i("data1", "url=error="+t.toString());
                pb.setVisibility(View.INVISIBLE);

                Toast.makeText(MainActivity.this, "Error while acquiring data", Toast.LENGTH_SHORT).show();

                finish();

            }
        });

    }

    public void onBackPressed()
    {
        finish();
    }
}
