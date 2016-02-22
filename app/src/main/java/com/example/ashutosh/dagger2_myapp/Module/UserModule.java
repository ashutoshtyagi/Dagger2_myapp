package com.example.ashutosh.dagger2_myapp.Module;

import com.example.ashutosh.dagger2_myapp.Annotations.PerUser;
import com.example.ashutosh.dagger2_myapp.Model.UserModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ashutosh on 8/1/16.
 */

@Module
public class UserModule {
    /*private String username, emailAddress, password;*/
    UserModel userModel;

    /*public UserModule(String username, String emailAddress, String password) {
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
    }*/

    public UserModule(UserModel userModel) {
        this.userModel = userModel;
    }

    @Provides @PerUser
    UserModel provideUserModelObject() {
        return userModel;
        /*return new UserModel(username, emailAddress, password);*/
    }
}
