package com.example.finalyearproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btn1 = (Button) findViewById(R.id.signUpBT);
        Button btn2 = (Button) findViewById(R.id.loginBT);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.signUpBT:
                Intent i1 = new Intent(this,SignUpActivity.class);
                startActivity(i1);
                break;
            case R.id.loginBT:
                Intent i2 = new Intent(this, LoginActivity.class);
                startActivity(i2);
                break;
            default:
                break;
        }
    }



}