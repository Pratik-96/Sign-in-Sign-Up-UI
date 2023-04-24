package com.example.login_signup;


import static com.example.login_signup.MainActivity.user_mail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class HomePage extends AppCompatActivity {
TextView txt;
dbHandler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        handler = new dbHandler(this,"U",null,1);
        txt = findViewById(R.id.Welcome);
                Intent HomeAct = getIntent();
String name="NULL";

            String mail = HomeAct.getStringExtra(user_mail);
             Cursor cursor = handler.getdet(mail);
             cursor.moveToFirst();
            if (cursor.getCount()==0)
            {
                Toast.makeText(this, "errr", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if (cursor.moveToNext())
                {
                    name = cursor.getString(0);
                }
            }

            txt.setText("Hello "+name);




        }

    }
