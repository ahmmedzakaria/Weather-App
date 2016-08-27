package com.example.ahmme.weatherapp;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by BITM Trainer - 401 on 7/31/2016.
 */
public class WeatherAppController extends Application {

    private static WeatherAppController instance;
    private RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public static synchronized WeatherAppController getInstance(){
        return instance;
    }

    private RequestQueue getRequestQueue(){

        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(this);
        }
        return requestQueue;
    }

    public  void addToRequestQueue(Request request){

        getRequestQueue().add(request);
    }
}
