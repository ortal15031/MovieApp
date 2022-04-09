package com.my_social_media.mymovies.Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.my_social_media.mymovies.Model.Movie;
import com.my_social_media.mymovies.MovieJasonDeserializer;

import java.lang.reflect.Type;
import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtil {

    private static String baseUrl = "https://api.themoviedb.org/3/movie/popular/";
    private static final Type movieArray = new ArrayList<Movie>().getClass();

    public static Api returnRetrofit() {
        Gson gson = new GsonBuilder().registerTypeAdapter(movieArray, new MovieJasonDeserializer()).create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson)).build();
        Api api = retrofit.create(Api.class);
        return api;

    }
}

