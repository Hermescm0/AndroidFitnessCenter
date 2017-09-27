package com.example.razer.fitnesscenter;

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


public class NewsController extends AppCompatActivity {
    int[] IMAGES = {R.drawable.guy, R.drawable.guy, R.drawable.guy, R.drawable.guy};
    String[] NAMES = {"Noticia", "Noticia2", "Noticia", "Noticia2"};
    String[] DESCRIPTIONS = {"Que hermosa noticia", "holis", "Noticia", "Noticia2"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        listView = (ListView) findViewById(R.id.news_list);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return IMAGES.length;
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
            TextView textView_description = (TextView) view.findViewById(R.id.news_description);

            imageView.setImageResource(IMAGES[i]);
            textView_title.setText(NAMES[i]);
            textView_description.setText(DESCRIPTIONS[i]);


            return view;

        }

    }

}
