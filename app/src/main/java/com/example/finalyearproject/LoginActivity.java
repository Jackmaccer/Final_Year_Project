package com.example.finalyearproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText email, password;
    Button login;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email_input_login);
        password = findViewById(R.id.password_input_login);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
               String Email = email.getText().toString();
               String Password = password.getText().toString();

               if (Patterns.EMAIL_ADDRESS.matcher(Email).matches() && Password.length()>= 8)
               {
                   mAuth.signInWithEmailAndPassword(Email,Password)
                           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task)
                               {
                                   if (task.isSuccessful())
                                   {
                                       FirebaseUser user = mAuth.getCurrentUser();
                                       /*getSupportFragmentManager().beginTransaction().add(R.id.frame_layout,new HomeFragment()).commit();*/
                                       Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                       startActivity(i);
                                       finish();

                                   }
                                   else
                                   {
                                       Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                   }

                               }
                           });
               }
               else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
               {
                   email.setError("Enter a valid Email Address");
                   email.requestFocus();
               }
               else
               {
                   password.setError("Password must be at least 8 characters long");
                   password.requestFocus();
               }
            }
        });
    }
}