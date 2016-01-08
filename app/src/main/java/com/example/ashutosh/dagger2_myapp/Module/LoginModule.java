package com.example.ashutosh.dagger2_myapp.Module;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.ashutosh.dagger2_myapp.Annotations.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ashutosh on 8/1/16.
 */

@Module
public class LoginModule {
    private AppCompatActivity activity;

    public LoginModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides @PerActivity
    ActionBar provideActionBar() {
        return activity.getSupportActionBar();
    }
}
