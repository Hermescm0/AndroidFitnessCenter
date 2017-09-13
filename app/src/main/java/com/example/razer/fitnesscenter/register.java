package com.example.razer.fitnesscenter;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText email = (EditText) findViewById(R.id.text_input_edit_email);
        final EditText password = (EditText) findViewById(R.id.text_input_edit_password);
        final Button validate = (Button) findViewById(R.id.appCompatButtonRegister);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateEmail(email.getText().toString())) {
                    email.setError("Please write a valid Email");
                    email.requestFocus();

                } else if (validatePassword(password.getText().toString())) {
                    password.setError("The password doesn't match");
                    password.requestFocus();
                } else {
                    setContentView(R.layout.activity_main_menu);
                    Toast.makeText(register.this, "Your account has been created", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    protected boolean validatePassword(String password) {
        EditText pwc = (EditText) findViewById(R.id.text_input_edit_confirm_password);

        if (!password.equals(pwc.getText().toString())) {
            return true;
        } else {
            return false;
        }
    }


    //validation of email
    protected boolean validateEmail(String email) {
        return !(email==null || TextUtils.isEmpty(email)) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
