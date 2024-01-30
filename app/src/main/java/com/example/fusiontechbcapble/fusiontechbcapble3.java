package com.example.fusiontechbcapble;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class fusiontechbcapble3 extends AppCompatActivity {

    Button button;
    ImageView btn;
    ImageView btn1;
    ImageView btn2;
    ImageView btn3;

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fusiontechbcapble3);

        button=findViewById(R.id.logout);
        auth= FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Intent intent=new Intent(fusiontechbcapble3.this,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });




        CardView card_view = (CardView) findViewById(R.id.Aboutcard);

        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(fusiontechbcapble3.this,aboutus2.class));
            }
        });
        btn=findViewById(R.id.ent);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://docs.google.com/document/d/12rvmmIID996jaWKkxL8iUh9_FyGY0IBh/edit?usp=sharing&ouid=104773273042996577001&rtpof=true&sd=true");
            }

            private void gotoUrl(String s) {
                Uri uri=Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
btn1=findViewById(R.id.res);
btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        gotoUrl("https://docs.google.com/document/d/1k8bQrXTe1gDcS5eQnY8YGU5icb8kSqqL/edit?usp=sharing&ouid=104773273042996577001&rtpof=true&sd=true");
    }

    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
});
btn2=findViewById(R.id.feed);
btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        gotoUrl("https://docs.google.com/forms/d/e/1FAIpQLSfIkHdsVyIDXg4kxQssD4vPrggy5fX8kH0hKa3wEQwj2k8QbQ/viewform?usp=sharing");
    }

    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
});
        btn3=findViewById(R.id.us);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(fusiontechbcapble3.this, Cus.class);
                startActivity(intent);
            }
});
    }
}