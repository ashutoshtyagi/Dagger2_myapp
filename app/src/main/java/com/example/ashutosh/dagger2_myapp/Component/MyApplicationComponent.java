package com.example.ashutosh.dagger2_myapp.Component;

import android.content.SharedPreferences;

import com.example.ashutosh.dagger2_myapp.Activity.HomePageActivity;
import com.example.ashutosh.dagger2_myapp.Module.MyApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ashutosh on 7/1/16.
 */

@Singleton
@Component(
        modules = {
                MyApplicationModule.class
        }
)
public interface MyApplicationComponent {

    void inject(HomePageActivity homePageActivity);

    SharedPreferences sharedPreferences();
}
