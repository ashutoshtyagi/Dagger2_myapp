package com.example.ashutosh.dagger2_myapp.Interface;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by ashutosh on 28/1/16.
 */
public interface OkHttpResponseCallback<T> {
    void onResponseFailed(IOException e);
    void onResponseSucceeded(T modelClassObject);
}
