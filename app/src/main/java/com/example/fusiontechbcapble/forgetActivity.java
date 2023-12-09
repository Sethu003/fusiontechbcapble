package com.example.fusiontechbcapble;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fusiontechbcapble.databinding.ActivityForgetBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class forgetActivity extends AppCompatActivity {

    ActivityForgetBinding binding;
    FirebaseAuth auth;
    FirebaseFirestore firestore;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityForgetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        firestore=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Create Your Account");
        progressDialog.setMessage("Please Wait");


        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=binding.foremail.getText().toString();

                if (email.isEmpty()){
                    binding.foremail.setError("Enter Email");
                    progressDialog.dismiss();
                }else {
                    auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()){
                                progressDialog.dismiss();
                                Toast.makeText(forgetActivity.this, "Please Check Your Email", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(forgetActivity.this,LoginActivity.class));
                            }else {
                                progressDialog.dismiss();
                                Toast.makeText(forgetActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }



                        }
                    });

                }
            }
        });




        binding.textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(forgetActivity.this, LoginActivity.class));
            }
        });



        //setContentView(R.layout.activity_forget);
    }
}