package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Obese extends AppCompatActivity {

    android.widget.Button back;

    android.widget.Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obese);
        getSupportActionBar().hide();

        back = findViewById(R.id.backbtn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Obese.this, BmiActivity.class);
                startActivity(intent);
                finish();

            }
        });

        click = findViewById(R.id.clickHere);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Obese.this, Serving.class);
                startActivity(intent);

            }
        });
    }
}