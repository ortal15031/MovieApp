package com.my_social_media.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MovieInfoActvity extends AppCompatActivity{
    
  private ImageView largeMovieImg;
  private TextView movieNameTv,overiewTv,releaseDateTv;
  private RatingBar ratingBar;
  private static String ImageUrl="https://image.tmdb.org/t/p/w300/";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie_info);
    init();
    getDataFromIntent();
  }

  private void init(){
  largeMovieImg=findViewById(R.id.larger_poster);
  movieNameTv=findViewById(R.id.name);
  overiewTv=findViewById(R.id.overview);
  releaseDateTv=findViewById(R.id.release_date);
  ratingBar=findViewById(R.id.rating);

  }

  private void getDataFromIntent(){
    Intent intent=getIntent();
     String name=intent.getStringExtra("movieName");
     String imgUrl=intent.getStringExtra("moviePoster");
     String overview=intent.getStringExtra("movieOverviews");
     String releaseDate=intent.getStringExtra("movieReleaseDate");
     Float rating=intent.getFloatExtra("movieRates",0);
     Glide.with(this).load(ImageUrl+imgUrl).into(largeMovieImg);
     movieNameTv.setText(name);
     overiewTv.setText(overview);
     releaseDateTv.setText(releaseDate);
     ratingBar.setRating(rating/2);


   }


}
