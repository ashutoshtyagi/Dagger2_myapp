package com.example.ashutosh.dagger2_myapp.Component;

import android.support.v7.app.ActionBar;

import com.example.ashutosh.dagger2_myapp.Annotations.PerActivity;
import com.example.ashutosh.dagger2_myapp.Module.LoginModule;
import com.example.ashutosh.dagger2_myapp.UI.ForgotPasswordLayout;
import com.example.ashutosh.dagger2_myapp.UI.LoginLayout;

import dagger.Component;

/**
 * Created by ashutosh on 8/1/16.
 */
@PerActivity
@Component(
        modules = {
                LoginModule.class
        }
)
public interface LoginComponent {

    void inject(LoginLayout loginLayout);

    void inject(ForgotPasswordLayout forgotPasswordLayout);
}
