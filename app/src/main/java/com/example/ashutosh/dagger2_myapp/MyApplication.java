package com.example.ashutosh.dagger2_myapp;

import android.app.Application;
import android.content.Context;

import com.example.ashutosh.dagger2_myapp.Component.DaggerMyApplicationComponent;
import com.example.ashutosh.dagger2_myapp.Component.MyApplicationComponent;
import com.example.ashutosh.dagger2_myapp.Module.MyApplicationModule;
import com.example.ashutosh.dagger2_myapp.Module.NetworkModule;

/**
 * Created by ashutosh on 7/1/16.
 */
public class MyApplication extends Application {

    private MyApplicationComponent myApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        myApplicationComponent = DaggerMyApplicationComponent.builder()
                .myApplicationModule(new MyApplicationModule(this))
                .networkModule(new NetworkModule(this))
                .build();
    }

    public static MyApplicationComponent getMyApplicationComponent(Context context) {
        return ((MyApplication) context.getApplicationContext()).myApplicationComponent;
    }
}
