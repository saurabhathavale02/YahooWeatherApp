package com.example.saurabh.weatherapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saurabh.weatherapp.custominterface.OnItemClickListener;
import com.example.saurabh.weatherapp.R;
import com.example.saurabh.weatherapp.pojoclass.Forecast;

import java.util.List;

/**
 * Created by saurabh on 08/10/16.
 */

public class WeatherAdapter  extends RecyclerView.Adapter<WeatherAdapter.ViewHolder>
{

    List<Forecast> forecast;
    OnItemClickListener clicklistener;

    public WeatherAdapter(List<Forecast> forecast)
    {
        this.forecast=forecast;
    }

    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecastlist_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherAdapter.ViewHolder holder, int position)
    {
        holder.day.setText(forecast.get(position).day);
        holder.date.setText(forecast.get(position).date);


    }

    @Override
    public int getItemCount() {
        return forecast.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView day,date;
        public ViewHolder(View itemView)
        {
            super(itemView);

            day = (TextView)itemView.findViewById(R.id.day);
            date = (TextView)itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            clicklistener.onClick(v,getPosition());
        }
    }

    public void SetOnItemClickListener(final OnItemClickListener clicklistener)
    {
        this.clicklistener=clicklistener;
    }
}
