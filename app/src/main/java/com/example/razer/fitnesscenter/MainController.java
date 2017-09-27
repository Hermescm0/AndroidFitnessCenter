package com.example.razer.fitnesscenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;


public class MainController extends AppCompatActivity {
    Button login, register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        login = (Button) findViewById(R.id.menu_button_login);
        register = (Button) findViewById(R.id.menu_button_register);

    }

//Abre Register Activity
    public void openRegister(View view) {
        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyIntent = new Intent(MainController.this, RegisterCreator.class);
                startActivity(MyIntent);
            }
        });

    }

    public void openNews(View view) {
        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyIntent = new Intent(MainController.this, NewsCreator.class);
                startActivity(MyIntent);
            }
        });

    }

}
