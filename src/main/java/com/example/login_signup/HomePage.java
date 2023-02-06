package com.example.login_signup;


import static com.example.login_signup.MainActivity.user_name;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomePage extends AppCompatActivity {
TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        txt = findViewById(R.id.Welcome);
                Intent HomeAct = getIntent();

            String name = HomeAct.getStringExtra(user_name);

            txt.setText(String.format("Welcome %s..", name.toUpperCase()));




        }

    }
