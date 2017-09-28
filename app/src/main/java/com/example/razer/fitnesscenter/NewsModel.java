package com.example.razer.fitnesscenter;

/**
 * Created by Lenovo on 9/27/2017.
 */

public class NewsModel {

    public String title;
    public String content;
    public String imageURL;
    public String date;

    public NewsModel(String t, String c, String url, String date){
        this.title = t;
        this.content = c;
        this.imageURL = url;
        this.date = date;
    }
}
