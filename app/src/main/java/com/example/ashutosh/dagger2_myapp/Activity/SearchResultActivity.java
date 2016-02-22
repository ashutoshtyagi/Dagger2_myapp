package com.example.ashutosh.dagger2_myapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashutosh.dagger2_myapp.Adapter.SearchResultAdapter;
import com.example.ashutosh.dagger2_myapp.Interface.OkHttpResponseCallback;
import com.example.ashutosh.dagger2_myapp.Model.SearchResultModel;
import com.example.ashutosh.dagger2_myapp.MyApplication;
import com.example.ashutosh.dagger2_myapp.R;
import com.example.ashutosh.dagger2_myapp.Utils;
import com.google.gson.Gson;

import java.io.IOException;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ashutosh on 28/1/16.
 */
public class SearchResultActivity extends AbstractUserActivity implements OkHttpResponseCallback<SearchResultModel> {

    public static String KEY_MOVIE_ID = "KEY_MOVIE_ID";

    @Bind(R.id.tv_response)
    TextView responseTv;

    @Bind(R.id.lv_movies)
    ListView moviesLv;

    @Inject
    OkHttpClient okHttpClient;

    @Inject
    Gson gson;

    private String searchString;
    private SearchResultModel searchResultModel;
    private SearchResultAdapter searchResultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        ButterKnife.bind(this);
        MyApplication.getMyApplicationComponent(this).inject(this);

        searchString = getIntent().getStringExtra(SearchFormActivity.SEARCH_STRING_KEY);

        try {
            getSearchResults();
        } catch (Exception e) {
            e.printStackTrace();
            responseTv.setText(e.toString());
        }
    }

    private void getSearchResults() throws Exception{
        Request request = new Request.Builder()
                .url(Utils.API_OMDB_SEARCH_RESULTS + "?s=" + searchString)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                e.printStackTrace();

                SearchResultActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        SearchResultActivity.this.onResponseFailed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                final SearchResultModel searchResultModel = gson.fromJson(response.body().charStream(), SearchResultModel.class);

                if (response.cacheResponse() != null) {
                    Log.e("OKHTTP", "Search Result Response received from cache");
                } else Log.e("OKHTTP", "Search Result Response received from network");

                Log.e("OKHTTP", "response = " + searchResultModel.toString());

                SearchResultActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        SearchResultActivity.this.onResponseSucceeded(searchResultModel);
                    }
                });
            }
        });
    }

    @Override
    public void onResponseFailed(IOException e) {
        responseTv.setText(e.toString());
    }

    @Override
    public void onResponseSucceeded(SearchResultModel modelClassObject) {
        searchResultModel = modelClassObject;
        responseTv.setVisibility(View.GONE);
        /*responseTv.setText(searchResultModel.toString());*/

        searchResultAdapter = new SearchResultAdapter(this,
                searchResultModel.getSearchResultsMovieModelList(),
                (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE));
        moviesLv.setAdapter(searchResultAdapter);
    }

    @OnItemClick(R.id.lv_movies) void onItemClick(int position) {
        Toast.makeText(this, "You clicked: " + searchResultAdapter.getItem(position), Toast.LENGTH_SHORT).show();

        SearchResultModel.SearchResultMovieModel movie = (SearchResultModel.SearchResultMovieModel) searchResultAdapter.getItem(position);
        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra(KEY_MOVIE_ID, movie.getImdbID());
        startActivity(intent);
    }
}