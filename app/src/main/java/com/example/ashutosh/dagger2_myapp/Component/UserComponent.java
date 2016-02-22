package com.example.ashutosh.dagger2_myapp.Component;

import com.example.ashutosh.dagger2_myapp.Annotations.PerUser;
import com.example.ashutosh.dagger2_myapp.Model.UserModel;
import com.example.ashutosh.dagger2_myapp.Module.UserModule;

import dagger.Component;

/**
 * Created by ashutosh on 8/1/16.
 */

@PerUser
@Component(
        modules = {
                UserModule.class
        }
)
public interface UserComponent {
        UserModel userModel();
}
