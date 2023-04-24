package com.example.login_signup;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.util.Patterns;
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

    EditText name;
    static EditText email;
    EditText pass;

    dbHandler handler;

    public static final String user_mail = "";
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
         email=findViewById(R.id.editTextTextEmailAddress);
        pass=findViewById(R.id.password);



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

        String key = pass.getText().toString();
        String mail = email.getText().toString();
        handler = new dbHandler(this,"U",null,1);
        if (handler.chkemailpass(mail,key)==false){         // Password checking
            Toast.makeText(this, "User Not Found..", Toast.LENGTH_SHORT).show();
        }
        else if (checked[0] == 1 && handler.chkemailpass(mail,key)==true) {

            Toast.makeText(Log_In.this, "Logging in..", Toast.LENGTH_SHORT).show();
//                    Log.d("btn", "onClick: Button is working properly..");
            Intent home = new Intent(getApplicationContext(),HomePage.class);

            startActivity(home);
        } else if (checked[0] == 0) {
            Toast.makeText(Log_In.this, "Please Accept our Terms And Conditions.", Toast.LENGTH_SHORT).show();
//                    Log.e("error", "onClick: Button is not working properly.." );
        }
    }


public static String share()
{
    String mail = email.getText().toString();
    return mail;
}

    public void signup(View v) {
        Intent act2 = new Intent(this, MainActivity.class);
        startActivity(act2);
    }
}
