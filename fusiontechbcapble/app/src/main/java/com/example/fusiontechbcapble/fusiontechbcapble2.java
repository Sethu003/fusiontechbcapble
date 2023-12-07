package com.example.fusiontechbcapble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

public class fusiontechbcapble2 extends AppCompatActivity {
    private MaterialButton materialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fusiontechbcapble2);
        materialButton=findViewById(R.id.button);
    }
}