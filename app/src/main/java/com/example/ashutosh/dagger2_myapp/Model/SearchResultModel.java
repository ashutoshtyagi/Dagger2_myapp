package com.example.ashutosh.dagger2_myapp.Model;

import com.google.gson.annotations.SerializedName;

import java.net.URL;
import java.util.List;

/**
 * Created by ashutosh on 28/1/16.
 */
public class SearchResultModel {

    @SerializedName("Search")
    private List<SearchResultMovieModel> searchResultsMovieModelList;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("Response")
    private boolean isSuccessful;

    public List<SearchResultMovieModel> getSearchResultsMovieModelList() {
        return searchResultsMovieModelList;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public class SearchResultMovieModel {
        @SerializedName("Title")
        private String title;

        @SerializedName("Year")
        private String year;

        @SerializedName("imdbID")
        private String imdbID;

        @SerializedName("Type")
        private String type;

        @SerializedName("Poster")
        private String posterUrl;

        public String getTitle() {
            return title;
        }

        public String getYear() {
            return year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public String getType() {
            return type;
        }

        public String getPosterUrl() {
            return posterUrl;
        }

        @Override
        public String toString() {
            return "SearchResultMovieModel{" +
                    "title='" + title + '\'' +
                    ", year=" + year +
                    ", imdbID='" + imdbID + '\'' +
                    ", type='" + type + '\'' +
                    ", posterUrl=" + posterUrl +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SearchResultModel{" +
                "searchResultsMovieModelList=" + searchResultsMovieModelList.toString() +
                ", totalResults=" + totalResults +
                ", isSuccessful=" + isSuccessful +
                '}';
    }
}
