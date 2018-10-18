package com.example.d2a.boxofiice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    private final ArrayList<Movie> movies;
    private LayoutInflater inflater;

    public  MovieListAdapter(Context context, ArrayList<Movie> inMovies){
        inflater = LayoutInflater.from(context);
        this.movies = inMovies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = inflater.inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie data = movies.get(position);
        holder.txtTitle.setText(data.title);
        holder.txtRating.setText("Rating: "+data.rating);
        holder.txtStatus.setText(data.getStatus());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        public final TextView txtTitle, txtRating, txtStatus;
        final MovieListAdapter adapter;

        public MovieViewHolder(View itemView, MovieListAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            this.txtTitle = (TextView) itemView.findViewById(R.id.title);
            this.txtRating = (TextView) itemView.findViewById(R.id.rating);
            this.txtStatus = (TextView) itemView.findViewById(R.id.status);
        }
    }
}
