package com.my_social_media.mymovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.my_social_media.mymovies.Adapter.MovieAdapter;
import com.my_social_media.mymovies.Model.Movie;
import com.my_social_media.mymovies.ViewModel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieAdapter.MoviesListener {
    private RecyclerView recyclerView;
    private MainActivityViewModel viewModel;
    private MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        viewModel= new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.returnList().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {

                adapter=new MovieAdapter(MainActivity.this,movies,MainActivity.this::onMovietClicked);
                recyclerView.setAdapter(adapter);


            }
        });
    }



    @Override
    public void onMovietClicked(int position) {

        Intent intent=new Intent(MainActivity.this,MovieInfoActvity.class);

        intent.putExtra("movieName",viewModel.returnList().getValue().get(position).getName());
        intent.putExtra("moviePoster",viewModel.returnList().getValue().get(position).getPoster());
        intent.putExtra("movieRates",viewModel.returnList().getValue().get(position).getVotes());
        intent.putExtra("movieReleaseDate",viewModel.returnList().getValue().get(position).getRelease_date());
        intent.putExtra("movieOverviews",viewModel.returnList().getValue().get(position).getOverview());
        startActivity(intent);
    }
}