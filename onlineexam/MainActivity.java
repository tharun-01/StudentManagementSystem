package com.example.onlineexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button signin,signup;
    CheckBox remeber;
    EditText us,pass;
    String username="";
    String password="";
    String name="";
    SharedPreferences sp,sp2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("welcome back");
        signin=findViewById(R.id.signin);
        us=findViewById(R.id.us);
        pass=findViewById(R.id.pass);
        signup=findViewById(R.id.signup);
        remeber=findViewById(R.id.remember);


        SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
        username=preferences.getString("username","");
        password=preferences.getString("password","");
        name=preferences.getString("name","");

        String checkbox=preferences.getString("remember","");

        if(checkbox.equals("true"))
        {
            Intent in=new Intent(getApplicationContext(),portal.class);
            startActivity(in);
        }
        else if(checkbox.equals("false"))
        {
            Toast.makeText(getApplicationContext(),"Please sign in",Toast.LENGTH_SHORT).show();
        }

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(us.getText().toString().isEmpty() || pass.getText().toString().isEmpty())
                {

                    Toast.makeText(getApplicationContext(),"fill required",Toast.LENGTH_SHORT).show();
                }
                else if(us.getText().toString().equals(username) && pass.getText().toString().equals(password))
                {
                    if(remeber.isChecked()) {

                        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("remember", "true");
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.apply();
                        editor.commit();

                    }
                        else
                        {
                            SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                            SharedPreferences.Editor editor=preferences.edit();
                            editor.putString("remember","false");
                            editor.apply();
                            editor.commit();

                        }



                    Intent in=new Intent(getApplicationContext(),portal.class);
                    in.putExtra("name",name);
                    startActivity(in);


                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid id or password\n or signup ",Toast.LENGTH_SHORT).show();

                }

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),signup.class);
                startActivity(in);
                finish();
            }
        });




    }

}