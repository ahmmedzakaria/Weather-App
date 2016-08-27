package com.example.ahmme.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String url = "http://api.openweathermap.org/data/2.5/forecast/city?id=524901&APPID=79e282ddbb2767f2eaf02e14fc3ffe8d";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPoetsName();
    }

    private void getPoetsName() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject jsonObject=response.getJSONObject("query");
                   // String country=jsonObject.getString("count");
                    JSONObject results=jsonObject.getJSONObject("results");
                    JSONObject channel=results.getJSONObject("channel");
                    JSONObject units=channel.getJSONObject("units");
                    String temperature=units.getString("temperature");
//                    JSONArray jsonArray = response.getJSONArray("poets");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        String name = jsonObject.getString("name");
//                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
//                    }
                    Toast.makeText(MainActivity.this,temperature, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                if (error instanceof NoConnectionError) {

                }

            }
        });
        WeatherAppController.getInstance().addToRequestQueue(request);
    }

    public void ShowDailyWeatherForecast(View view) {
        Intent intent=new Intent(MainActivity.this,DailyForecastActivity.class);
        startActivity(intent);
    }

    public void hourlyForeCast(View view) {
        Intent intent=new Intent(MainActivity.this,HourlyForecastActivity.class);
        startActivity(intent);
    }
}
