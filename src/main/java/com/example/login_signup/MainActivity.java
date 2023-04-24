package com.example.login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private CheckBox chkbx;
    private Button Signup;
    private TextView reg;

    private EditText Pass1;
    private EditText Pass2;
    private EditText Name;
    private static EditText email;
    private EditText phone;
    final int[] checked = new int[1];
//    public static final String user_mail = "";

    dbHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chkbx = findViewById(R.id.checkBox);
        Signup = findViewById(R.id.button);
        Pass1 = findViewById(R.id.password);
        Pass2 = findViewById(R.id.cnfpassword);
        Name = findViewById(R.id.Name);
        reg = findViewById(R.id.noacc);
        email=findViewById(R.id.editTextTextEmailAddress);
        phone=findViewById(R.id.editTextPhone);
        



        String txt = "<b>I agree to the <a href='www.google.com'>Terms & Conditions</a></b>";
        chkbx.setText(Html.fromHtml(txt));
        String txt2 = "<b>Already have an account ? <a href=''>Log In</a></b>";
        reg.setText(Html.fromHtml(txt2));


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




        }
         public void register(View v){
        Intent act2 = new Intent(this,Log_In.class);            // Login Listener
        startActivity(act2);
    }
    public void signup(View view){
//        Check box Checking && Name checking
        boolean flag = true;
        String key = Pass1.getText().toString();
        String key2 = Pass2.getText().toString();
        if (!key.equals(key2)){         // Password checking
            flag=false;
            Toast.makeText(this, "Passwords are not matching..", Toast.LENGTH_SHORT).show();
        }
        else {
            flag=true;
        }
        
        
        // Email Validation
        String mail =email.getText().toString();
        boolean mailchk=false;
        if (!mail.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            mailchk=true;
        }
        else {
            mailchk=false;
            Toast.makeText(this, "Invalid Email..", Toast.LENGTH_SHORT).show();
        }

//        Phone Number check
        String mobile = phone.getText().toString();
        boolean mobchk=false;
        if (!mobile.isEmpty() && Patterns.PHONE.matcher(mobile).matches() && mobile.length()==10)
        {
            mobchk=true;
        }
        else
        {
            mobchk=false;
            Toast.makeText(this, "Invalid Mobile Number..", Toast.LENGTH_SHORT).show();
        }
        


        if (checked[0] == 1 && flag && mailchk && mobchk) {

            String User_Name = Name.getText().toString();
            String User_Email = email.getText().toString();
            String User_Pass = Pass2.getText().toString();
            String no = phone.getText().toString();
            dbHandler handler = new dbHandler(this,"U",null,1);

            Boolean chkmail = handler.chkemail(User_Email);

            if (chkmail==false)
            {
                Boolean Insert = handler.addUser(new user(User_Name,User_Email,User_Pass,no));
                if (Insert==true)
                {
                    Toast.makeText(MainActivity.this, "Signing Up..", Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(this,Log_In.class);
                    startActivity(home);
                }
                else
                {
                    Toast.makeText(this, "SignUp Failed..", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this, "User Already Exists , Please Login to continue..", Toast.LENGTH_SHORT).show();
            }



//                    Log.d("btn", "onClick: Button is working properly..");
            String name = Name.getText().toString();


        } else if (checked[0] == 0) {
            Toast.makeText(MainActivity.this, "Please Accept our Terms And Conditions.", Toast.LENGTH_SHORT).show();
//                    Log.e("error", "onClick: Button is not working properly.." );
            

        }

    }

}
