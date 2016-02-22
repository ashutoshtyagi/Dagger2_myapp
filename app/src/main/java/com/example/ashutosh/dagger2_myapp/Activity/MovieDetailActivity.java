package com.example.ashutosh.dagger2_myapp.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ashutosh.dagger2_myapp.Interface.OkHttpResponseCallback;
import com.example.ashutosh.dagger2_myapp.Model.MovieDetailModel;
import com.example.ashutosh.dagger2_myapp.Model.SearchResultModel;
import com.example.ashutosh.dagger2_myapp.MyApplication;
import com.example.ashutosh.dagger2_myapp.R;
import com.example.ashutosh.dagger2_myapp.Utils;
import com.google.gson.Gson;

import java.io.IOException;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ashutosh on 31/1/16.
 */
public class MovieDetailActivity extends AbstractUserActivity implements OkHttpResponseCallback<MovieDetailModel> {

    @Bind(R.id.tv_movie_detail)
    TextView movieDetailTv;

    @Inject
    OkHttpClient okHttpClient;

    @Inject
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        ButterKnife.bind(this);
        MyApplication.getMyApplicationComponent(this).inject(this);

        String movieImdbId = getIntent().getStringExtra(SearchResultActivity.KEY_MOVIE_ID);
        try {
            getSearchResults(movieImdbId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getSearchResults(String movieImdbId) throws Exception{
        Request request = new Request.Builder()
                .url(Utils.API_OMDB_MOVIE_DETAIL + "?i=" + movieImdbId)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                e.printStackTrace();

                MovieDetailActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MovieDetailActivity.this.onResponseFailed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                final MovieDetailModel movieDetailModel = gson.fromJson(response.body().charStream(), MovieDetailModel.class);

                if (response.cacheResponse() != null) {
                    Log.e("OKHTTP", "Search Result Response received from cache");
                } else Log.e("OKHTTP", "Search Result Response received from network");

                Log.e("OKHTTP", "response = " + movieDetailModel.toString());

                MovieDetailActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MovieDetailActivity.this.onResponseSucceeded(movieDetailModel);
                    }
                });
            }
        });
    }

    @Override
    public void onResponseFailed(IOException e) {
        movieDetailTv.setText(e.toString());
    }

    @Override
    public void onResponseSucceeded(MovieDetailModel modelClassObject) {
        movieDetailTv.setText(modelClassObject.toString());
    }
}
