package com.example.onlineexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Exam extends AppCompatActivity {
    RadioButton ra1,ra2,ra3,ra4,ra5,ra6,ra7,ra8,ra9,ra10;
    Button submit;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        submit=findViewById(R.id.submit);
        getSupportActionBar().setTitle("All the Best");
        ra1=findViewById(R.id.ra1);
        ra2=findViewById(R.id.ra2);
        ra3=findViewById(R.id.ra3);
        ra4=findViewById(R.id.ra4);
        ra5=findViewById(R.id.ra5);
        ra6=findViewById(R.id.ra6);
        ra7=findViewById(R.id.ra7);
        ra8=findViewById(R.id.ra8);
        ra9=findViewById(R.id.ra9);
        ra10=findViewById(R.id.ra10);


    }

    public void positivefun(View view)
    {
        result=10;
        if(!ra1.isChecked())
        {
            result-=1;
        }
        if(!ra2.isChecked())
        {
            result-=1;
        }
        if(!ra3.isChecked())
        {
            result-=1;
        }
        if(!ra4.isChecked())
        {
            result-=1;
        }
        if(!ra5.isChecked())
        {
            result-=1;
        }
        if(!ra6.isChecked())
        {
            result-=1;
        }
        if(!ra7.isChecked())
        {
            result-=1;
        }
        if(!ra8.isChecked())
        {
            result-=1;
        }
        if(!ra9.isChecked())
        {
            result-=1;
        }
        if(!ra10.isChecked())
        {
            result-=1;
        }
        final AlertDialog.Builder builder=new AlertDialog.Builder(Exam.this);
        View postive=getLayoutInflater().inflate(R.layout.alertresource,null);
        TextView yes=(TextView)postive.findViewById(R.id.yes);
        yes.setText("You got "+String.valueOf(result)+" out of 10");
        TextView feed=(TextView)postive.findViewById(R.id.feedback);
        if(result<=5)
        {
            feed.setText("Better luck next time");
        }
        else
        {
            feed.setText("Great");
        }
        Button btn=(Button)postive.findViewById(R.id.contpositi);
        builder.setView(postive);
        Intent inst=new Intent(getApplicationContext(),portal.class);
        inst.putExtra("result",result);
        inst.putExtra("bool",1);
        final AlertDialog alert=builder.create();
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.dismiss();
                startActivity(inst);
            }
        });

        alert.show();





    }
}