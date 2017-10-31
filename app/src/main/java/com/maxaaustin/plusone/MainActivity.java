package com.maxaaustin.plusone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    GridLayoutManager mGridLayoutManager;

    String[] nameList = {
            "American", "Barbecue", "Chinese", "French", "Indian", "Italian", "Japanese", "Mediterranean"
    };
    int[] cuisineIconID = {
            R.drawable.american, R.drawable.bbq, R.drawable.chinese, R.drawable.french, R.drawable.indian, R.drawable.italian, R.drawable.japanese3, R.drawable.mediterranean
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerGuest();
        addListenerHost();

    }

    public void addListenerGuest(){
        final Context context = this;

        Button button1 = findViewById(com.maxaaustin.plusone.R.id.buttonOne);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(context, GuestMap.class);
                startActivity(map);
            }
        });
    }

    public void addListenerHost(){
        final Context context = this;

        Button button1 = findViewById(R.id.buttonTwo);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent host = new Intent(getApplicationContext(), HostMain.class);
                startActivity(host);
            }
        });
    }

}
