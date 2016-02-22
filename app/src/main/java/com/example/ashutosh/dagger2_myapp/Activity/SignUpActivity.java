package com.example.ashutosh.dagger2_myapp.Activity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.ashutosh.dagger2_myapp.Component.DaggerUserComponent;
import com.example.ashutosh.dagger2_myapp.Model.UserModel;
import com.example.ashutosh.dagger2_myapp.R;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.Provides;

/**
 * Created by ashutosh on 7/1/16.
 */
public class SignUpActivity extends AbstractUserActivity {

    @Bind(R.id.et_username)
    @NotEmpty
    EditText usernameEt;

    @Bind(R.id.et_password)
    @Password
    EditText passwordEt;

    @Bind(R.id.et_email)
    @Email
    @NotEmpty
    EditText emailEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.b_sign_up)
    public void onClickSignUp() {
        UserModel userModel = new UserModel(usernameEt.getText().toString(),
                emailEt.getText().toString(),
                passwordEt.getText().toString());
        createUserComponent(userModel);
    }
}
