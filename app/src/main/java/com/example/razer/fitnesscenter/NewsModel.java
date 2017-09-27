package com.example.razer.fitnesscenter;

/**
 * Created by Lenovo on 9/27/2017.
 */

public class NewsModel {

    public String title;
    public String content;
    public int image;

    public NewsModel(String t, String c, int url){
        this.title = t;
        this.content = c;
        this.image = url;
    }
}
