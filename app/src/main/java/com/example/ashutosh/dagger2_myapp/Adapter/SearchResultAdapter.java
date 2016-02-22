package com.example.ashutosh.dagger2_myapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashutosh.dagger2_myapp.Model.SearchResultModel;
import com.example.ashutosh.dagger2_myapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ashutosh on 28/1/16.
 */
public class SearchResultAdapter extends BaseAdapter {
    private List<SearchResultModel.SearchResultMovieModel> dataList;
    private Context context;
    private LayoutInflater layoutInflater;

    public SearchResultAdapter(Context context, List<SearchResultModel.SearchResultMovieModel> dataList, LayoutInflater layoutInflater) {
        this.context = context;
        this.dataList = dataList;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return -1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieListViewHolder movieListViewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.adapter_item_search_result_adapter, parent, false);

            movieListViewHolder = new MovieListViewHolder();
            movieListViewHolder.titleTv = (TextView) convertView.findViewById(R.id.tv_title);
            movieListViewHolder.yearTv = (TextView) convertView.findViewById(R.id.tv_year);
            movieListViewHolder.imdbIdTv = (TextView) convertView.findViewById(R.id.tv_imdbid);
            movieListViewHolder.typeTv = (TextView) convertView.findViewById(R.id.tv_type);
            movieListViewHolder.posterIv = (ImageView) convertView.findViewById(R.id.iv_poster);

            convertView.setTag(movieListViewHolder);
        } else movieListViewHolder = (MovieListViewHolder) convertView.getTag();

        SearchResultModel.SearchResultMovieModel searchResultMovieModel = dataList.get(position);

        movieListViewHolder.titleTv.setText(searchResultMovieModel.getTitle());
        movieListViewHolder.yearTv.setText(searchResultMovieModel.getYear());
        movieListViewHolder.imdbIdTv.setText(searchResultMovieModel.getImdbID());
        movieListViewHolder.typeTv.setText(searchResultMovieModel.getType());
        Picasso.with(context)
                .load(searchResultMovieModel.getPosterUrl())
                .into(movieListViewHolder.posterIv);

        return convertView;
    }

    public class MovieListViewHolder {
        TextView titleTv;
        TextView yearTv;
        TextView imdbIdTv;
        TextView typeTv;
        ImageView posterIv;
    }
}
