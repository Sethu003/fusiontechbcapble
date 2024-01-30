package com.example.fusiontechbcapble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class profile extends AppCompatActivity {
    ImageView btn;
    ImageView btn1;
    ImageView btn2;
    ImageView btn3;
    ImageView btn4;
    ImageView btn5;
    ImageView btn6;
    ImageView btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        btn=findViewById(R.id.imageView12);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.linkedin.com/in/sethu-venkat-2a005b21b?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }

            private void gotoUrl(String s) {
                Uri uri=Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
        btn1=findViewById(R.id.imageView10);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("Turlapatisethu@gmail.com");
            }

            private void gotoUrl(String s) {
                Uri uri=Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
        btn2=findViewById(R.id.imageView11);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.instagram.com/sethu_006?igsh=MTloMGp4dnRnZTBlZA==");

            }

            private void gotoUrl(String s) {
                Uri uri=Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));

            }
        });
        btn3=findViewById(R.id.imageView13);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://x.com/Sethu_003?t=oMhMN5RC0DrLwX4pu-ubtQ&s=08");
            }

            private void gotoUrl(String s) {
                Uri uri=Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
        btn4=findViewById(R.id.imageView5);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("harshagnareddy64@gmail.com");
            }

            private void gotoUrl(String s) {
                Uri uri=Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
        btn5=findViewById(R.id.imageView8);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.linkedin.com/in/harshagna-reddy-1667ab24b?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }

            private void gotoUrl(String s) {
                Uri uri=Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
        btn6=findViewById(R.id.imageView7);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.instagram.com/harsh10_43?utm_source=qr&igsh=MXhyYWNsbXIyeHUyOQ==");
            }

            private void gotoUrl(String s) {
                Uri uri=Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
        btn7=findViewById(R.id.imageView9);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://x.com/Harshagna_Reddy?t=UiVK-pa7-Yxf1lKXfIOA_Q&s=08");
            }

            private void gotoUrl(String s) {
                Uri uri=Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
    }
}