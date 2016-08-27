package com.example.ahmme.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmme.weatherapp.WeatherInfo;

import java.util.ArrayList;

/**
 * Created by ahmme on 04-08-16.
 */
public class HourlyForecastCustomAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<WeatherInfo> weatherInfoArrayList;
    ViewHolder viewHolder;
    WeatherManager manager=new WeatherManager();

    public HourlyForecastCustomAdapter(Context context, ArrayList<WeatherInfo> weatherInfoArrayList) {
        super(context, R.layout.hourly_forcust_row_layout,weatherInfoArrayList);
        this.context=context;
        this.weatherInfoArrayList=weatherInfoArrayList;
    }

    public class ViewHolder{
        TextView hourlyForecastDateTV;
        TextView hourlyForecastTimeTV;
        TextView hourlyForecastWeatherConditionTV;
        TextView hourlyForecastHumidityTV;
        TextView hourlyForecastWindTV;
        TextView hourlyForecastTemperatureTV;
        ImageView hourlyForecastImageIV;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.hourly_forcust_row_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.hourlyForecastDateTV = (TextView) convertView.findViewById(R.id.hourlyForecastDate);
            viewHolder.hourlyForecastTimeTV = (TextView) convertView.findViewById(R.id.hourlyForecastTime);
            viewHolder.hourlyForecastWeatherConditionTV = (TextView) convertView.findViewById(R.id.hourlyWeatherState);
            viewHolder.hourlyForecastHumidityTV =(TextView)convertView.findViewById(R.id.hourlyForecastHumidity);
            viewHolder.hourlyForecastWindTV =(TextView)convertView.findViewById(R.id.hourlyForecastWind);
            viewHolder.hourlyForecastTemperatureTV =(TextView)convertView.findViewById(R.id.hourlyForecastTemperatur);
            viewHolder.hourlyForecastImageIV =(ImageView) convertView.findViewById(R.id.hourlyWeatherImage);
            convertView.setTag(viewHolder);
        }
        else {
            convertView.getTag();
        }
        viewHolder.hourlyForecastDateTV.setText(weatherInfoArrayList.get(position).getDate());
        viewHolder.hourlyForecastTimeTV.setText(weatherInfoArrayList.get(position).getTime());
        viewHolder.hourlyForecastWeatherConditionTV.setText(weatherInfoArrayList.get(position).getWeatherCondition());
        viewHolder.hourlyForecastHumidityTV.setText("Humidity: "+String.valueOf(weatherInfoArrayList.get(position).getHumidity()));
        viewHolder.hourlyForecastWindTV.setText("Wind: "+String.valueOf(weatherInfoArrayList.get(position).getWind())+"Km/h");
        viewHolder.hourlyForecastTemperatureTV.setText(String.valueOf(weatherInfoArrayList.get(position).getTemperature())+"\u2103");

        return convertView;
    }
}
