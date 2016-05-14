package com.icetea09.demomaterialdesigncard.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.icetea09.demomaterialdesigncard.R;
import com.icetea09.demomaterialdesigncard.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<Movie> mItems;

    public CardAdapter(List<Movie> items) {
        if (items == null) {
            items = new ArrayList<>();
        }
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_card_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Movie movie = mItems.get(i);
        viewHolder.tvMovie.setText(movie.name);
        viewHolder.imgThumbnail.setImageBitmap(movie.imageBitmap);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgThumbnail;
        public TextView tvMovie;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.img_thumbnail);
            tvMovie = (TextView) itemView.findViewById(R.id.tv_movie);
        }
    }

    public List<Movie> getItems() {
        return mItems;
    }
}
