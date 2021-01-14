package com.example.onlineexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class portal extends AppCompatActivity {
    ImageView exam,results;
    int result,bl;
    Intent intent;
    String namess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);

        exam=findViewById(R.id.exam);
        results=findViewById(R.id.results);
        intent=getIntent();
        result=intent.getIntExtra("result",0);
        bl=intent.getIntExtra("bool",-1);
        Intent pp=getIntent();

        namess=pp.getStringExtra("name");
        getSupportActionBar().setTitle("Welcome "+namess);
//        ActionBar ab=getActionBar();
//        ab.setTitle(namess);


        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),Exam.class);
                startActivity(in);
            }
        });
        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(portal.this);
                View postive=getLayoutInflater().inflate(R.layout.alertresource,null);
                TextView yes=(TextView)postive.findViewById(R.id.yes);
                TextView feed=(TextView)postive.findViewById(R.id.feedback);
                if(bl==-1)
                {
                    yes.setText("you havent attempted any text");
                    feed.setText("please go through exam");
                }

                else
                {
                    yes.setText("You got "+String.valueOf(result)+" out of 10");
                    if (result <= 5) {
                        feed.setText("Better luck next time");
                    } else {
                        feed.setText("Great");
                    }
                }
                Button btn=(Button)postive.findViewById(R.id.contpositi);
                builder.setView(postive);
                Intent inst=new Intent(getApplicationContext(),portal.class);
                inst.putExtra("result",result);
                final AlertDialog alert=builder.create();
                alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert.dismiss();

                    }
                });

                alert.show();
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);


        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.logout:
                SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("remember","false");
                editor.commit();
                finish();
                Intent in=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);

                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}