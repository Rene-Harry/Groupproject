package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Underweight extends AppCompatActivity {


    android.widget.Button back;

    android.widget.Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_underweight);
        getSupportActionBar().hide();

        back = findViewById(R.id.backbtn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Underweight.this, BmiActivity.class);
                startActivity(intent);
                finish();

            }
        });

        click = findViewById(R.id.clickHere);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Underweight.this, Serving.class);
                startActivity(intent);

            }
        });
    }
}