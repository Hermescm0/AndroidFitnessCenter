package com.example.razer.fitnesscenter;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;


public class NewsController extends AppCompatActivity{

    ArrayList<NewsModel> news = new ArrayList<NewsModel>();

    ListView listView;

    private RequestQueue mRequestQueue;

    private StringRequest stringRequest;
    private String url = "http://boundlessfitnesscenter.com/app/news.php?token=kvein1321032mkd21324";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        sendRequestandPrintRespond();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()){
                    case R.id.itemBarcode:
                        intent = new Intent(NewsController.this, BarcodeController.class);
                        break;


                }

                if(intent != null){
                    startActivity(intent);
                }
                return true;
            }
        });



        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.navigation);
    }

    private void sendRequestandPrintRespond() {
        mRequestQueue = Volley.newRequestQueue(this);
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject json = new JSONObject(response);
                    JSONArray newsJson = json.getJSONArray("News");
                    for(int i = 0; i < newsJson.length(); i++){

                        JSONObject jsonNew = newsJson.getJSONObject(i);
                        String title = jsonNew.getString("title");
                        String content = jsonNew.getString("message");
                        String url = jsonNew.getString("image");
                        String date = jsonNew.getString("date");

                        news.add(new NewsModel(title, content, url, date));

                    }
                    listView = (ListView) findViewById(R.id.news_list);
                    CustomAdapter customAdapter = new CustomAdapter();
                    listView.setAdapter(customAdapter);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("a",error.getMessage());
            }
        }
        );
        stringRequest.setTag("request");
        mRequestQueue.add(stringRequest);
    }

    protected void onStop(){
        super.onStop();
        if(mRequestQueue!=null){
            mRequestQueue.cancelAll("request");
        }
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
            TextView textView_date = (TextView) view.findViewById(R.id.news_date);
            TextView textView_image = (TextView) view.findViewById(R.id.news_image_url);

            Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
            textView_title.setTypeface(myFont);

            TextView textBackground = (TextView) view.findViewById(R.id.text_background);
            textBackground.getBackground().setAlpha(60);

            Picasso.with(getApplicationContext()).load(news.get(i).imageURL).placeholder(R.drawable.guy).into(imageView);
            textView_title.setText(news.get(i).title);
            textView_content.setText(news.get(i).content);
            textView_date.setText(news.get(i).date);
            textView_image.setText(news.get(i).imageURL);
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

                    TextView dateContent = (TextView) v.findViewById(R.id.news_date);
                    String date = dateContent.getText().toString();
                    intent.putExtra("date",date);


                    TextView imageContent = (TextView) v.findViewById(R.id.news_image_url);
                    String image = imageContent.getText().toString();
                    intent.putExtra("image",image);

                    startActivity(intent);
                }
            });

            return view;

        }

    }

}