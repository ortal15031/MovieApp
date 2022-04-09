package com.my_social_media.mymovies.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Movie implements Serializable {

    @SerializedName("title")
    private String name;
    @SerializedName("vote_average")
    private float votes;
    @SerializedName("poster_path")
    private String poster;
    private String release_date;
    private String overview;

    public Movie() {
    }

    public Movie(String name, float votes, String poster, String release_date, String overview) {
        this.name = name;
        this.votes = votes;
        this.poster = poster;
        this.release_date = release_date;
        this.overview = overview;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getVotes() {
        return votes;
    }

    public void setVotes(float votes) {
        this.votes = votes;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }



}
