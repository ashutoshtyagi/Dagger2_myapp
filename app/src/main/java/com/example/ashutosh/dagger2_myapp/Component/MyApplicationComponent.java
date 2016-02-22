package com.example.ashutosh.dagger2_myapp.Component;

import android.content.SharedPreferences;

import com.example.ashutosh.dagger2_myapp.Activity.HomePageActivity;
import com.example.ashutosh.dagger2_myapp.Activity.LoginActivity;
import com.example.ashutosh.dagger2_myapp.Activity.MovieDetailActivity;
import com.example.ashutosh.dagger2_myapp.Activity.SearchResultActivity;
import com.example.ashutosh.dagger2_myapp.Db.UserDbHelper;
import com.example.ashutosh.dagger2_myapp.Module.MyApplicationModule;
import com.example.ashutosh.dagger2_myapp.Module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by ashutosh on 7/1/16.
 */

@Singleton
@Component(
        modules = {
                MyApplicationModule.class,
                NetworkModule.class
        }
)
public interface MyApplicationComponent {

    void inject(HomePageActivity homePageActivity);

    void inject(LoginActivity loginActivity);

    void inject(SearchResultActivity searchResultActivity);

    void inject(MovieDetailActivity movieDetailActivity);

    SharedPreferences sharedPreferences();

    UserDbHelper userDbHelper();

    /*OkHttpClient okHttpClient();*/
}
