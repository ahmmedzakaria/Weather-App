package com.example.ahmme.weatherapp;

/**
 * Created by ahmme on 04-08-16.
 */
public class WeatherInfo {
    private String time;
    private String date;
    private String weatherCondition;
    private float humidity;
    private float wind;
    private float temperature;

    public WeatherInfo(String time, String date, String weatherCondition, float humidity, float wind, float temperature) {
        this.time = time;
        this.date = date;
        this.weatherCondition = weatherCondition;
        this.humidity = humidity;
        this.wind = wind;
        this.temperature = temperature;
    }

    public WeatherInfo() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getWind() {
        return wind;
    }

    public void setWind(float wind) {
        this.wind = wind;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
