package com.example.fusiontechbcapble;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fusiontechbcapble.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    FirebaseAuth auth;
    FirebaseFirestore firestore;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firestore=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Create Your Account");
        progressDialog.setMessage("Please Wait");

        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });

        binding.logbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String email=binding.username1.getText().toString();
               String password=binding.password1.getText().toString();

              if (email.isEmpty()) {
                    binding.username1.setError("Enter your email");
                } else if (password.isEmpty()) {
                    binding.password1.setError("Enter Your Password");
                }else{

                  progressDialog.show();
                  auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {

                          if (task.isSuccessful()){
                              progressDialog.dismiss();
                              startActivity(new Intent(LoginActivity.this, fusiontechbcapble3.class));
                                finish();
                          } else {
                              progressDialog.dismiss();
                              Toast.makeText(LoginActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();


                          }

                      }
                  });

              }


            }
        });





        binding.forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, forgetActivity.class));
            }
        });


        //setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStart(){
        super.onStart();
        if(auth.getCurrentUser() != null){
            Toast.makeText(LoginActivity.this,"Already Logged In",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this,fusiontechbcapble3.class));
            finish();
        } else {
            Toast.makeText(LoginActivity.this,"Login",Toast.LENGTH_SHORT).show();
        }
    }
}