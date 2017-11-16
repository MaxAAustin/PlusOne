package com.maxaaustin.plusone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class CuisineRecyclerActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine_recycler);

        mRecyclerView = findViewById(com.maxaaustin.plusone.R.id.cuisine_recyclerview);
        mLayoutManager = new GridLayoutManager(this, 3);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemViewCacheSize(10);
        mRecyclerView.setDrawingCacheEnabled(true);
        mRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CuisineAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

}
