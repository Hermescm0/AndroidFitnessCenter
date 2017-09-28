package com.example.razer.fitnesscenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.net.URL;

public class NewsSingleController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_single_controller);

        Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        Typeface boundlessFont = Typeface.createFromAsset(getAssets(), "fonts/BebasNeue.otf");


        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        TextView textTitle = (TextView) findViewById(R.id.textTitle);


        TextView textContent = (TextView) findViewById(R.id.textContent);
        textTitle.setText(title);
        textContent.setText(content);

        textContent.setTypeface(myFont);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(getApplicationContext()).load("http://www.vip-polymers.com/wp-content/uploads/2015/03/news.jpg").error(R.drawable.guy).into(imageView);
    }
}
