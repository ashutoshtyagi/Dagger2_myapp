package com.example.ashutosh.dagger2_myapp.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.ashutosh.dagger2_myapp.Component.DaggerUserComponent;
import com.example.ashutosh.dagger2_myapp.Component.UserComponent;
import com.example.ashutosh.dagger2_myapp.Model.UserModel;
import com.example.ashutosh.dagger2_myapp.Module.UserModule;
import com.example.ashutosh.dagger2_myapp.R;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ashutosh on 7/1/16.
 */
public class SignUpActivity extends AppCompatActivity {

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

    private UserComponent userComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.b_sign_up)
    public void onClickSignUp() {
        userComponent = DaggerUserComponent
                .builder()
                .build();

        userComponent.inject(new UserModel(
                usernameEt.getText().toString(),
                emailEt.getText().toString(),
                passwordEt.getText().toString())
        );


    }
}
