package com.maxaaustin.plusone.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.maxaaustin.plusone.R;

/**
 * Created by maaus on 10/30/2017.
 */

public class CuisineAdapter extends Adapter<com.maxaaustin.plusone.adapter.CuisineAdapter.CuisineHolder> {

    private android.content.Context context;
    private int[] cuisineImageArray;
    private String[] cuisineNameArray;

    public CuisineAdapter(android.content.Context context, int[] cuisineImageArray, String[] cuisineNameArray) {
        this.context = context;
        this.cuisineImageArray = cuisineImageArray;
        this.cuisineNameArray = cuisineNameArray;
    }



    @Override
    public CuisineHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(com.maxaaustin.plusone.R.layout.activity_cuisine_grid, null);
        CuisineHolder cuisineHolder = new CuisineHolder(layout);

        return cuisineHolder;
    }

    @Override
    public void onBindViewHolder(CuisineHolder holder, int position) {

        holder.cuisineImg.setImageResource(cuisineImageArray[position]);
        holder.cuisineTxt.setText(cuisineNameArray[position]);

    }

    @Override
    public int getItemCount() {
        return cuisineNameArray.length;
    }

    public static class CuisineHolder extends android.support.v7.widget.RecyclerView.ViewHolder {

        android.widget.ImageView cuisineImg;
        android.widget.TextView cuisineTxt;

        public CuisineHolder(View itemView) {
            super(itemView);
            cuisineImg = itemView.findViewById(R.id.cuisineImageView);
            cuisineTxt = itemView.findViewById(R.id.cuisineTextView);
        }
    }

}
