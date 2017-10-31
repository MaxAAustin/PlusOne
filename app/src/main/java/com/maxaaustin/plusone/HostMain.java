package com.maxaaustin.plusone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class HostMain extends AppCompatActivity {

    private Button mHostDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_main);

        mHostDetail = findViewById(com.maxaaustin.plusone.R.id.hostDetailID);
        mHostDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu mPopUpMenu = new PopupMenu(HostMain.this, view);
                mPopUpMenu.getMenuInflater().inflate(R.menu.host_popup_menu, mPopUpMenu.getMenu());

                mPopUpMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(HostMain.this, "You clicked: " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                mPopUpMenu.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.host_popup_menu, menu);
        return true;
    }
}
