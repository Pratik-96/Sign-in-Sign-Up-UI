package com.example.login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox chkbx;
    private Button Signup;
    private TextView reg;

    private EditText Pass1, Pass2, Name;
    final int[] checked = new int[1];
    public static final String user_name = "";

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



        String txt = "<b>I agree to the <a href=''>Terms & Conditions</a></b>";
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
        Intent act2 = new Intent(this,Log_In.class);
        startActivity(act2);
    }
    public void signup(View view){
//        Check box Checking && Name checking
        if (checked[0] == 1) {
            Toast.makeText(MainActivity.this, "Signing Up..", Toast.LENGTH_SHORT).show();
//                    Log.d("btn", "onClick: Button is working properly..");
            String name = Name.getText().toString();
            Intent home = new Intent(this,HomePage.class);
            home.putExtra(user_name,name);
            startActivity(home);
        } else if (checked[0] == 0) {
            Toast.makeText(MainActivity.this, "Please Accept our Terms And Conditions.", Toast.LENGTH_SHORT).show();
//                    Log.e("error", "onClick: Button is not working properly.." );
        }
    }
}
