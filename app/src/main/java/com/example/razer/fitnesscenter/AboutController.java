package com.example.razer.fitnesscenter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AboutController extends AppCompatActivity {

    Button signOut, privacy, support;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.itemSettings);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()){
                    case R.id.itemBarcode:
                        intent = new Intent(AboutController.this, BarcodeController.class);
                        break;
                    case R.id.itemNews:
                        intent = new Intent(AboutController.this, NewsController.class);
                        break;

                }

                if(intent != null){
                    startActivity(intent);
                }
                return true;
            }
        });



        signOut = (Button) findViewById(R.id.sign_out_button);
        privacy = (Button) findViewById(R.id.privacy_button);
        support = (Button) findViewById(R.id.support_button);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

}
