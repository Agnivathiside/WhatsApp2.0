package com.example.whatsapp20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.whatsapp20.databinding.ActivitySignupBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();

//        Objects.requireNonNull(getSupportActionBar()).hide();
//        Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        progressDialog=new ProgressDialog(SignupActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We are creating your account");

        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(binding.txtusername.getText().toString().isEmpty() && binding.txtemail.getText().toString().isEmpty() && binding.txtpassword.getText().toString().isEmpty())){
                    Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Fill up the details", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}