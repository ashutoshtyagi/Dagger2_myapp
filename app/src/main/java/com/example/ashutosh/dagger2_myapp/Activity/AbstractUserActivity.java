package com.example.ashutosh.dagger2_myapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ashutosh.dagger2_myapp.Component.DaggerUserComponent;
import com.example.ashutosh.dagger2_myapp.Component.UserComponent;
import com.example.ashutosh.dagger2_myapp.Model.UserModel;
import com.example.ashutosh.dagger2_myapp.Module.UserModule;

/**
 * Created by ashutosh on 11/1/16.
 */
public class AbstractUserActivity extends AppCompatActivity {

    private UserComponent userComponent;

    protected UserComponent getUserComponent() {
        return userComponent;
    }

    /*protected void createUserComponent(String username, String emailAddress, String password) {
        userComponent = DaggerUserComponent
                .builder()
                .userModule(new UserModule(username, emailAddress, password))
                .build();
    }*/

    protected void createUserComponent(UserModel userModel) {
        userComponent = DaggerUserComponent
                .builder()
                .userModule(new UserModule(userModel))
                .build();
    }
}
