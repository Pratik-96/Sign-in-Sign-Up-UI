package com.example.login_signup;

import static com.example.login_signup.MainActivity.user_name;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Log_In extends AppCompatActivity {
    TextView txt,txt2;
    CheckBox chkbx;
    Button Login;

    EditText txt3;


    final int[] checked = new int[1];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        txt = findViewById(R.id.forgotpass);
        chkbx = findViewById(R.id.checkBox);
        String url = " <a href=''>Forgot Password ?</a>";
        txt.setText(Html.fromHtml(url));
        txt2 = findViewById(R.id.sign);
        Login = findViewById(R.id.button);
        txt3 = findViewById(R.id.Name);


        String txt3 = "Don't have an Account ? <a href=''>Sign Up</a>";
        txt2.setText(Html.fromHtml(txt3));
        String txt = "<b>I agree to the <a href=''>Terms & Conditions</a></b>";
        chkbx.setText(Html.fromHtml(txt));
        chkbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)  //If check Box is Checked or not
                {
                    checked[0] = 1;
                } else {
                    checked[0] = 0;
                }

            }
        });


//        Login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Check box Checking && Name checking
//                if (checked[0] == 1) {
//                    Toast.makeText(Log_In.this, "Thank You for using our Application..!!", Toast.LENGTH_SHORT).show();
////                    Log.d("btn", "onClick: Button is working properly..");
//                } else if (checked[0] == 0) {
//                    Toast.makeText(Log_In.this, "Please Accept our Terms And Conditions.", Toast.LENGTH_SHORT).show();
////                    Log.e("error", "onClick: Button is not working properly.." );
//                }
//
//
//            }
//        });
//
//    }
    }
    public void login(View view){
//        Check box Checking && Name checking
        if (checked[0] == 1) {
            Toast.makeText(Log_In.this, "Logging in..", Toast.LENGTH_SHORT).show();
//                    Log.d("btn", "onClick: Button is working properly..");
            String name = txt3.getText().toString();
            Intent home = new Intent(this,HomePage.class);
            home.putExtra(user_name,name);
            startActivity(home);
        } else if (checked[0] == 0) {
            Toast.makeText(Log_In.this, "Please Accept our Terms And Conditions.", Toast.LENGTH_SHORT).show();
//                    Log.e("error", "onClick: Button is not working properly.." );
        }
    }



    public void signup(View v) {
        Intent act2 = new Intent(this, MainActivity.class);
        startActivity(act2);
    }
}
