package com.example.ashutosh.dagger2_myapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.ashutosh.dagger2_myapp.R;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ashutosh on 7/1/16.
 */
public class SearchFormActivity extends AbstractUserActivity {

    public static final String SEARCH_STRING_KEY = "SEARCH_STRING_KEY";

    @Bind(R.id.et_movie_name)
    @NotEmpty
    EditText movieEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_form);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Search Movie");
    }

    @OnClick(R.id.b_search)
    public void onSearchClick() {
        Intent intent = new Intent(this, SearchResultActivity.class);
        intent.putExtra(SEARCH_STRING_KEY, movieEt.getText().toString());
        startActivity(intent);
    }

    @OnClick(R.id.tv_username)
    public void onClickUsername() {

    }
}
