package com.my_social_media.mymovies.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.my_social_media.mymovies.Api.Api;
import com.my_social_media.mymovies.Api.ApiUtil;
import com.my_social_media.mymovies.Model.Movie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {

   public static final String TAG="MainActivityViewModel";
   private MutableLiveData<List<Movie>>mData;
   private static final String apiKey="9b62c3eb4a6bc8acd4e26602f16fa744";

    public void loadData(){
     Api api= ApiUtil.returnRetrofit();
     Call<ArrayList<Movie>>getMovies=api.getList(apiKey);
     getMovies.enqueue(new Callback<ArrayList<Movie>>() {

     @Override
     public void onResponse(Call<ArrayList<Movie>> call, Response<ArrayList<Movie>> response) {
     mData.setValue(response.body());
     Log.e(TAG,"operation success");
     }

     @Override
     public void onFailure(Call<ArrayList<Movie>> call, Throwable t) {
     Log.e(TAG,t.toString());
            }
        });

    }
    public LiveData<List<Movie>> returnList(){
    if(mData==null){
    mData=new MutableLiveData<>();
    loadData();

    }
    return mData;
    }

}
