package com.example.ashutosh.dagger2_myapp.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.example.ashutosh.dagger2_myapp.Component.DaggerLoginComponent;
import com.example.ashutosh.dagger2_myapp.Component.LoginComponent;
import com.example.ashutosh.dagger2_myapp.Module.LoginModule;
import com.example.ashutosh.dagger2_myapp.R;
import com.example.ashutosh.dagger2_myapp.UI.ForgotPasswordLayout;
import com.example.ashutosh.dagger2_myapp.UI.LoginLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ashutosh on 7/1/16.
 */
public class LoginActivity extends AppCompatActivity {

    public static String ACTIVE_USER_KEY = "ACTIVE_USER_KEY";
    private LoginComponent loginComponent;

    @Bind(R.id.vg_login)
    LoginLayout loginLayout;

    @Bind(R.id.vg_forgot_password)
    ForgotPasswordLayout forgotPasswordLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginComponent = DaggerLoginComponent.builder()
                .loginModule(new LoginModule(this))
                .build();

        loginComponent.inject(loginLayout);
        loginComponent.inject(forgotPasswordLayout);
    }

    @OnClick(R.id.b_forgot_password)
    public void onClickForgotPassword() {
        loginLayout.setVisibility(View.GONE);
        forgotPasswordLayout.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.b_send_mail)
    public void onClickSendMail() {
        forgotPasswordLayout.setVisibility(View.GONE);
        loginLayout.setVisibility(View.VISIBLE);
    }
}
