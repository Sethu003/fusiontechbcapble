package com.example.fusiontechbcapble;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class aboutus2 extends AppCompatActivity {
    ImageView btn;
    ImageView btn2;
ImageView btn3;
ImageView btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus2);
        btn=findViewById(R.id.xxx);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(aboutus2.this, aboutus.class);
                startActivity(intent);
            }
        });
        btn2=findViewById(R.id.teacher);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(aboutus2.this, aboutusfaculty.class);
                startActivity(intent);

            }
        });
        btn3=findViewById(R.id.obj);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(aboutus2.this, objectives.class);
                startActivity(intent);
            }
        });

        btn4=findViewById(R.id.act);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://docs.google.com/spreadsheets/d/14ZSvO9JSNNaLucOySri0-zUQO8DE7d79/edit?usp=sharing&ouid=104773273042996577001&rtpof=true&sd=true");


        }

            private void gotoUrl(String s) {
                Uri uri=Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
            });
    }
}