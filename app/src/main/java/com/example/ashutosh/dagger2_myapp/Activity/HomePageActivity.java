package com.example.ashutosh.dagger2_myapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.ashutosh.dagger2_myapp.MyApplication;

import javax.inject.Inject;

/**
 * Created by ashutosh on 7/1/16.
 */
public class HomePageActivity extends Activity {

    @Inject SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getMyApplicationComponent(this).inject(this);

        if (sharedPreferences.contains(LoginActivity.ACTIVE_USER_KEY)) {
            startActivity(new Intent(this, SearchFormActivity.class));
        } else {
            startActivity(new Intent(this, SignUpActivity.class));
        }
    }
}
