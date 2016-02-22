package com.example.ashutosh.dagger2_myapp.Model;

import javax.inject.Inject;

/**
 * Created by ashutosh on 8/1/16.
 */
public class UserModel {
    private String userName, emailAddress, password;

    public UserModel(String userName, String emailAddress, String password) {
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }
}
