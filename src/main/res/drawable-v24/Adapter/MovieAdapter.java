package com.my_social_media.mymovies.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.my_social_media.mymovie.Model.Movie;
import com.my_social_media.mymovie.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> mData;
    private Context context;
    private static String imageUrl="https://image.tmdb.org/t/p/w300/";
    private MoviesListener listener;


    public MovieAdapter(Context context, List<Movie> mData,MoviesListener listener) {
        this.context = context;
        this.mData = mData;
        this.listener=listener;
    }

  public interface MoviesListener {
        void onMovietClicked(int position);
    }



    public void setListener(MoviesListener listener) {
        this.listener = listener;
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView movieNameTv;
        ImageView movieImg;
        public MovieViewHolder(View itemview) {
            super(itemview);
            movieNameTv=itemview.findViewById(R.id.movie_name);
            movieImg=itemview.findViewById(R.id.movie_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null)

                        listener.onMovietClicked(getBindingAdapterPosition());
                }
            });
        }
    }

    @Override

    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        MovieViewHolder holder = new MovieViewHolder(view);
        return holder;

    }

    @Override

    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = mData.get(position);
        holder.movieNameTv.setText(movie.getName());
        Glide.with(context).load(imageUrl+movie.getPoster()).into(holder.movieImg);

    }

    @Override

    public int getItemCount() {
        return mData.size();
    }

}




