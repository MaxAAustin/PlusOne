package com.maxaaustin.plusone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.maxaaustin.plusone.adapter.CuisineAdapter;

public class CuisineGrid extends AppCompatActivity {

    RecyclerView mRecyclerView;
    GridLayoutManager mGridLayoutManager;

    private String[] nameList = {};
    private int[] cuisineIconID = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine_grid);

        mRecyclerView = findViewById(R.id.cuisineRV);
        mGridLayoutManager = new GridLayoutManager(CuisineGrid.this, 3);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        CuisineAdapter cuisineAdapter = new CuisineAdapter(CuisineGrid.this, cuisineIconID, nameList);
        mRecyclerView.setAdapter(cuisineAdapter);
    }
}
