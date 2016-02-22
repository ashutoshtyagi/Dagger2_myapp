package com.example.ashutosh.dagger2_myapp.Module;

import com.example.ashutosh.dagger2_myapp.MyApplication;
import com.google.gson.Gson;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by ashutosh on 28/1/16.
 */

@Module
public class NetworkModule {
    private final MyApplication myApplication;

    public NetworkModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Provides
    @Singleton
    Cache providesCache() {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        File cacheDirectory = new File(myApplication.getCacheDir(), "http");
        return new Cache(cacheDirectory, cacheSize);
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    Gson providesGson() {
        return new Gson();
    }
}
