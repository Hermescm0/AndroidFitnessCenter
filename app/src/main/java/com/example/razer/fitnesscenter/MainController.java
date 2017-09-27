package com.example.razer.fitnesscenter;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;


public class MainController extends AppCompatActivity {
    Button btnLogin, btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnLogin = (Button) findViewById(R.id.menu_button_login);
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyIntent = new Intent(MainController.this, NewsController.class);
                startActivity(MyIntent);
            }
        });

        btnRegister = (Button) findViewById(R.id.menu_button_register);

        btnRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyIntent = new Intent(MainController.this, RegisterController.class);
                startActivity(MyIntent);
            }
        });
    }


}
