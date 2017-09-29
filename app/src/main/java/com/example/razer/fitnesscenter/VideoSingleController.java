package com.example.razer.fitnesscenter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

public class VideoSingleController extends AppCompatActivity {

    String videoPath;
    Uri uri;
    VideoView videov;
    MediaController mediac;

    ArrayList<VideoModel> media = new ArrayList<VideoModel>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_single_controller);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        TextView textTitle = (TextView) findViewById(R.id.single_media_title);
        TextView textContent = (TextView) findViewById(R.id.single_media_description);
        videov = (VideoView)findViewById(R.id.single_video_view);
        mediac = new MediaController(this);
        textTitle.setText(title);
        textContent.setText(content);

        videoPath = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
        uri = Uri.parse(videoPath);
        videov.setVideoURI(uri);
        videov.setMediaController(mediac);
        mediac.setAnchorView(videov);
        videov.start();
        videov.pause();;
        videov.seekTo(100);




    }

}