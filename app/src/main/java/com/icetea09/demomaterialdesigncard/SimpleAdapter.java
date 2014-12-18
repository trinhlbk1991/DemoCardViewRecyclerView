package com.icetea09.demomaterialdesigncard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

    List<String> mItems;

    public SimpleAdapter() {
        super();
        mItems = new ArrayList<String>();
        mItems.add("Amazing Spiderman 2");
        mItems.add("The Guardians of Galaxy");
        mItems.add("What If");
        mItems.add("Big Hero 6");
        mItems.add("The Hunger Game");
        mItems.add("X-men: Days of Future Past");
        mItems.add("The Lego Movie");
        mItems.add("How to Train Your Dragon 2");
        mItems.add("Maleficent");
        mItems.add("22 Jump Street");
        mItems.add("The Maze Runner");
        mItems.add("Horrible Bosses 2");
        mItems.add("Night at the Museum 3");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_simple_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemView.setText(mItems.get(i));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = (TextView)itemView.findViewById(R.id.tv_recycler_view_item);
        }
    }
}
