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
    /*private String username, emailAddress, password;

    public UserModule(String username, String emailAddress, String password) {
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    @Provides @PerUser
    UserModel provideUserModelObject() {
        return new UserModel(username, emailAddress, password);
    }*/
}
