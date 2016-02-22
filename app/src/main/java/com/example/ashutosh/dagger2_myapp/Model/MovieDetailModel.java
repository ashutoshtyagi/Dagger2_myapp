package com.example.ashutosh.dagger2_myapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ashutosh on 31/1/16.
 */
public class MovieDetailModel {

    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    @SerializedName("Rated")
    private String rated;

    @SerializedName("Released")
    private String released;

    @SerializedName("Runtime")
    private String runtime;

    @SerializedName("Genre")
    private String genre;

    @SerializedName("Director")
    private String director;

    @SerializedName("Actors")
    private String actors;

    @SerializedName("Plot")
    private String plot;

    @SerializedName("imdbRating")
    private String imdbRating;

    @SerializedName("Website")
    private String website;

    @SerializedName("imdbID")
    private String imdbID;

    @SerializedName("Poster")
    private String posterUrl;

    @SerializedName("Response")
    private String response;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getGenre() {
        return genre;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getDirector() {
        return director;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getWebsite() {
        return website;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "MovieDetailModel{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", rated='" + rated + '\'' +
                ", released='" + released + '\'' +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", website='" + website + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
