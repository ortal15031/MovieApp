package com.my_social_media.mymovies.Api;


import com.my_social_media.mymovies.Model.Movie;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {


    @GET(".")
    Call<ArrayList<Movie>>getList(@Query("api_key")String api_key);




}
