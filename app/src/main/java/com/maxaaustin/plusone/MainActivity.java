package com.maxaaustin.plusone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
                Intent map = new Intent(context, HostMain.class);
                startActivity(map);
            }
        });
    }

}
