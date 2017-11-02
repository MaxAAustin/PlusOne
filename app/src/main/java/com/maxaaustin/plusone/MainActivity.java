package com.maxaaustin.plusone;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaychang.sa.SocialUser;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String EXTRA_USER_NAME = "EXTRA_USER_NAME";
    private static final String EXTRA_PIC = "EXTRA_PIC";

    @BindView(R.id.nameText)
    TextView mUserNameView;

    @BindView(R.id.profilePicture)
    ImageView mUserImageView;

    public static void start(Context context, String type, SocialUser socialUser) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_USER_NAME, socialUser.fullName);
        intent.putExtra(EXTRA_PIC, socialUser.profilePictureUrl);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //get user name from the session
        String userName=getIntent().getStringExtra(EXTRA_USER_NAME);
        //get user name from the session
        String url=getIntent().getStringExtra(EXTRA_PIC);


        mUserNameView.setText(userName);
        Picasso.with(this).load(url).into(mUserImageView);
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
                Intent host = new Intent(context, com.maxaaustin.plusone.CuisineRecyclerActivity.class);
                startActivity(host);
            }
        });
    }


}
