package com.example.razer.fitnesscenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterCreator extends AppCompatActivity {
    Button validate;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText) findViewById(R.id.text_input_edit_email);
        password = (EditText) findViewById(R.id.text_input_edit_password);
        validate = (Button) findViewById(R.id.menu_button_register);

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
        return !(email == null || TextUtils.isEmpty(email)) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public void validate(View view) {
        // Do something in response to button
        if (!validateEmail(email.getText().toString())) {
            email.setError("Please write a valid Email");
            email.requestFocus();

        } else if (validatePassword(password.getText().toString())) {
            password.setError("The password doesn't match");
            password.requestFocus();
        } else {
            Intent intent = new Intent(this, MainController.class);
            startActivity(intent);
            Toast.makeText(RegisterCreator.this, "Your account has been created", Toast.LENGTH_LONG).show();
        }

    }
}
