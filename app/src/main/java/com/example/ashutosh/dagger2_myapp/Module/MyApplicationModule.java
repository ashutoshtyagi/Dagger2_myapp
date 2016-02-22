package com.example.ashutosh.dagger2_myapp.Module;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.ashutosh.dagger2_myapp.MyApplication;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by ashutosh on 7/1/16.
 */

@Module
public class MyApplicationModule {
    private final MyApplication myApplication;
    private final String SHARED_PREFERENCE_KEY = "SHARED_PREFERENCE";

    public MyApplicationModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Provides @Singleton
    SharedPreferences provideSharedPreferences() {
        return myApplication.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE);
    }

    @Provides @Singleton
    ContentValues provideContentValues() {
        return new ContentValues();
    }

    @Provides @Singleton
    Context provideApplicationContext() {
        return myApplication.getApplicationContext();
    }
}