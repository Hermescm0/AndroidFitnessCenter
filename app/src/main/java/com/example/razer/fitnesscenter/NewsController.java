package com.example.razer.fitnesscenter;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class NewsController extends AppCompatActivity {

    ArrayList<NewsModel> news = new ArrayList<NewsModel>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Agrega una noticia
        news.add(new NewsModel("Bienvenido a Boundless", "Que hermosa noticia", R.drawable.ic_news));
        news.add(new NewsModel("Noticia de prueba", "Que hermosa noticia", R.drawable.guy));
        news.add(new NewsModel("Usando Roboto Thin", "Que hermosa noticia", R.drawable.guy));
        news.add(new NewsModel("Noticia", "Que hermosa noticia", R.drawable.ic_news));


        setContentView(R.layout.activity_news);

        listView = (ListView) findViewById(R.id.news_list);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return news.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.custom_news_layout, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.news_image);
            TextView textView_title = (TextView) view.findViewById(R.id.news_title);
            Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
            textView_title.setTypeface(myFont);

            TextView textBackground = (TextView) view.findViewById(R.id.text_background);
            textBackground.getBackground().setAlpha(60);

            imageView.setImageResource(news.get(i).image);
            textView_title.setText(news.get(i).title);

            return view;

        }

    }

}