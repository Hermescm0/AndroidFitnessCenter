package com.example.razer.fitnesscenter;

/**
 * Created by Lenovo on 9/27/2017.
 */

public class VideoModel {

    public String title;
    public String content;
    public String videoPath;

    public VideoModel(String t, String c, String url){
        this.title = t;
        this.content = c;
        this.videoPath = url;
    }
}
