package com.example.ahmme.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class HourlyForecastActivity extends AppCompatActivity {
    ListView listView;
    HourlyForecastCustomAdapter adapter;
    WeatherInfo weatherInfo;
    ArrayList<WeatherInfo> weatherInfoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);
        listView=(ListView)findViewById(R.id.hourlyListView);
        weatherInfo=new WeatherInfo("21-07-16","3:20","cloudy",30.0f,24.9f,38.6f);
        weatherInfoArrayList=new ArrayList<>();
        weatherInfoArrayList.add(weatherInfo);
        weatherInfoArrayList.add(weatherInfo);
        adapter=new HourlyForecastCustomAdapter(HourlyForecastActivity.this,weatherInfoArrayList);
        listView.setAdapter(adapter);

    }
}
