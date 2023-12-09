package com.example.fusiontechbcapble;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fusiontechbcapble.Model.My_Models;
import com.example.fusiontechbcapble.databinding.ActivitySignup2Binding;
import com.example.fusiontechbcapble.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignupActivity extends AppCompatActivity {

    //ActivitySignup2Binding binding;
    ActivitySignup2Binding binding;
    FirebaseAuth auth;
    FirebaseFirestore firestore;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivitySignup2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firestore=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Create Your Account");
        progressDialog.setMessage("Please Wait");

        binding.btnsignupnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=binding.username.getText().toString();
                String email=binding.email1.getText().toString();
                String password=binding.mypassword.getText().toString();
                
                if (name.isEmpty()){
                    binding.username.setError("Enter Your Name");
                } else if (email.isEmpty()) {
                    binding.email1.setError("Enter your email");
                } else if (password.isEmpty()) {
                    binding.mypassword.setError("Enter Your Password");
                }else{

                    progressDialog.show();
                    auth.createUserWithEmailAndPassword(binding.email1.getText().toString(),binding.mypassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                My_Models models= new My_Models(name,email,password);

                                String id=task.getResult().getUser().getUid();
                                firestore.collection("users").document().set(models).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            progressDialog.dismiss();
                                            Toast.makeText(SignupActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });


                            }

                        }
                    });
                }


            }
        });

        binding.btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this,LoginActivity.class));
            }
        });




       // setContentView(R.layout.activity_signup2);
    }
}