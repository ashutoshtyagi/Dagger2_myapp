package com.example.ashutosh.dagger2_myapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ashutosh.dagger2_myapp.Component.DaggerLoginComponent;
import com.example.ashutosh.dagger2_myapp.Component.LoginComponent;
import com.example.ashutosh.dagger2_myapp.Component.MyApplicationComponent;
import com.example.ashutosh.dagger2_myapp.Db.UserDbHelper;
import com.example.ashutosh.dagger2_myapp.Model.UserModel;
import com.example.ashutosh.dagger2_myapp.Module.LoginModule;
import com.example.ashutosh.dagger2_myapp.MyApplication;
import com.example.ashutosh.dagger2_myapp.R;
import com.example.ashutosh.dagger2_myapp.UI.ForgotPasswordLayout;
import com.example.ashutosh.dagger2_myapp.UI.LoginLayout;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ashutosh on 7/1/16.
 */
public class LoginActivity extends AbstractUserActivity {

    public static String ACTIVE_USER_KEY = "ACTIVE_USER_KEY";
    private LoginComponent loginComponent;

    @Inject
    UserDbHelper userDbHelper;

    @Bind(R.id.vg_login)
    LoginLayout loginLayout;

    @Bind(R.id.vg_forgot_password)
    ForgotPasswordLayout forgotPasswordLayout;

    @Bind(R.id.et_username)
    @NotEmpty
    EditText usernameEt;

    @Bind(R.id.et_password)
    @Password
    EditText passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        MyApplication.getMyApplicationComponent(this).inject(this);

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

    @OnClick(R.id.b_sign_up)
    public void onClickSignUp() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.b_login)
    public void onClickLogin() {
        if (userDbHelper.isPresent(usernameEt.getText().toString())) {
            UserModel userModel = userDbHelper.getData(usernameEt.getText().toString());
            createUserComponent(userModel);

            startActivity(new Intent(this, SearchFormActivity.class));
        } else {
            // TODO show error message
        }
    }
}
