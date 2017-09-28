package com.example.razer.fitnesscenter;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class NewsController extends AppCompatActivity{

    ArrayList<NewsModel> news = new ArrayList<NewsModel>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // Agrega una noticia
        news.add(new NewsModel("Miles de estudiantes estarán presentes este evento 2016", "Esta es una prueba de la primera noticia. Todo va saliendo bien. Mas palabras para que se vea mas contenido.", "http://www.vip-polymers.com/wp-content/uploads/2015/03/news.jpg","September 28th, 2017"));
        news.add(new NewsModel("Excelente evento", "Que hermosa noticia", "http://www.vip-polymers.com/wp-content/uploads/2015/03/news.jpg","September 28th, 2017"));
        news.add(new NewsModel("Usando Roboto Thin", "Que hermosa noticia", "http://www.vip-polymers.com/wp-content/uploads/2015/03/news.jpg","September 28th, 2017"));
        news.add(new NewsModel("Noticia", "Que hermosa noticia", "http://www.vip-polymers.com/wp-content/uploads/2015/03/news.jpg","September 28th, 2017"));



        listView = (ListView) findViewById(R.id.news_list);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);


        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.navigation);
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
            TextView textView_content = (TextView) view.findViewById(R.id.news_content);
            Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
            textView_title.setTypeface(myFont);

            TextView textBackground = (TextView) view.findViewById(R.id.text_background);
            textBackground.getBackground().setAlpha(60);

            Picasso.with(getApplicationContext()).load(news.get(i).imageURL).into(imageView);
            textView_title.setText(news.get(i).title);
            textView_content.setText(news.get(i).content);
            view.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(NewsController.this, NewsSingleController.class);


                    TextView textTitle = (TextView) v.findViewById(R.id.news_title);
                    String title = textTitle.getText().toString();
                    intent.putExtra("title",title);

                    TextView textContent = (TextView) v.findViewById(R.id.news_content);
                    String content = textContent.getText().toString();
                    intent.putExtra("content",content);


                    startActivity(intent);
                }
            });
            return view;

        }

    }

}