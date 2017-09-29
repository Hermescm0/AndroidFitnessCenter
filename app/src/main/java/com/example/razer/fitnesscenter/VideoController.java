package com.example.razer.fitnesscenter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

//import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;


public class VideoController extends AppCompatActivity {

    ArrayList<VideoModel> media = new ArrayList<VideoModel>();

    ListView listView;
    VideoView videov;
    Button button;
    String videoPath;
    Uri uri;
    //ExpandableTextView expandableTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        media.add(new VideoModel("Video1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc non enim euismod purus elementum maximus. Proin convallis auctor dui vitae scelerisque. Aliquam interdum lacinia lectus sed varius. Mauris molestie velit vitae dapibus lacinia. Nunc non justo accumsan leo interdum vestibulum. Integer laoreet sit amet ante vel posuere. In at magna facilisis, pretium nibh id, hendrerit nunc.\n" +
                "\n" +
                "Fusce vitae leo et erat tempor fermentum eget vel dui. Nulla sodales augue et massa eleifend, ut vulputate mauris interdum. Maecenas hendrerit nunc vitae erat dignissim, vel feugiat ex dapibus. Curabitur et neque nec odio efficitur laoreet eget in felis. Integer rhoncus vitae enim vel pulvinar. Aliquam erat volutpat. Cras laoreet ut mauris vel vehicula. Sed leo dui, pulvinar vitae nibh eget, tempor ultricies felis. Suspendisse fermentum quam a orci accumsan imperdiet. Proin ultricies fermentum pulvinar. Nullam commodo ligula nibh.\n" +
                "\n" +
                "Suspendisse pretium egestas erat. Vivamus nec viverra nunc, sed fringilla nisl. In pretium congue quam et commodo. Fusce convallis blandit ante, nec suscipit nisi fringilla quis. Aliquam porttitor id nisl sit amet tempor. Vivamus nulla justo, lobortis at sodales eu, auctor eget tortor. Nullam quis rhoncus turpis, vitae ultricies urna. Phasellus vulputate laoreet nisl vitae luctus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;\n" +
                "\n" +
                "Nulla vulputate molestie tincidunt. Integer vel iaculis lacus. Duis consectetur lectus ac nisl fermentum lobortis. Ut imperdiet, lectus eu egestas bibendum, elit sem consequat augue, at consectetur sem sem nec odio. In hac habitasse platea dictumst. Pellentesque semper in metus eu consectetur. Duis imperdiet fringilla tellus eu ultrices. Mauris mi ex, fermentum id lobortis ut, finibus eu nunc. Aliquam felis ipsum, commodo quis lectus eu, auctor molestie mi. In sed libero sit amet eros consequat pretssium. Sed molestie volutpat magna ac rutrum.", "http://clips.vorwaerts-gmbh.de/VfE_html5.mp4"));
        media.add(new VideoModel("Video2", "Que hermosa video", "http://clips.vorwaerts-gmbh.de/VfE_html5.mp4"));

        setContentView(R.layout.activity_media);




        listView = (ListView)findViewById(R.id.media_list) ;
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

//        listView = (ListView) findViewById(R.id.news_list);
//        CustomAdapter customAdapter = new CustomAdapter();
//        listView.setAdapter(customAdapter);

    }


    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return media.size();
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
            view = getLayoutInflater().inflate(R.layout.custom_media_layout, null);
            TextView textView_title = (TextView) view.findViewById(R.id.media_title);
            TextView textView_description = (TextView) view.findViewById(R.id.media_description);
            //Button button = (Button) view.findViewById(R.id.button2);
            videov = (VideoView)view.findViewById(R.id.image_video_view);
            //expandableTextView = (ExpandableTextView)view.findViewById(R.id.expandable_text_view);
            videoPath = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
            uri = Uri.parse(videoPath);
            videov.setVideoURI(uri);
            videov.start();
            videov.pause();
            videov.seekTo(100);


            textView_title.setText(media.get(i).title);
            textView_description.setText((media.get(i).content));

            //textView_description.setText(media.get(i).content);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent MyIntent = new Intent(VideoController.this, VideoSingleController.class);
                    startActivity(MyIntent);
                }
            });



            return view;

        }

    }

}