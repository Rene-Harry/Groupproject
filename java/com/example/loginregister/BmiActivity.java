package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {


    android.widget.Button recalculateBmi;
    android.widget.Button recommend;


    TextView mbmiDisplay;
    TextView mgenderDisplay;
    TextView mcategoryDisplay;

    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;


    String height;
    String weight;
    float intheight;
    float intweight;
    RelativeLayout mbackground;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        getSupportActionBar().hide();

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#AEC57B"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        intent=getIntent();

        mbmiDisplay=findViewById(R.id.bmiDisplay);
        mcategoryDisplay=findViewById(R.id.categoryDisplay);
        mgenderDisplay=findViewById(R.id.genderDisplay);
        mbackground=findViewById(R.id.contentlayout);
        mimageview=findViewById(R.id.imageview);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;

        intbmi=intweight/(intheight*intheight);

        mbmi=Float.toString(intbmi);

        if(intbmi<18.5){
            mcategoryDisplay.setText("Underweight");
            mimageview.setImageResource(R.drawable.crosss);

            recommend = findViewById(R.id.recommendbtn);

            recommend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(BmiActivity.this, Underweight.class);
                    startActivity(intent);


                }
            });
        }
        else if(intbmi>=18.5 && intbmi<25){
            mcategoryDisplay.setText("Healthy Weight");
            mimageview.setImageResource(R.drawable.ok);

            recommend = findViewById(R.id.recommendbtn);

            recommend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(BmiActivity.this, NormalWeight.class);
                    startActivity(intent);


                }
            });
        }
        else if(intbmi<30 && intbmi>=25){
            mcategoryDisplay.setText("Overweight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);

            recommend = findViewById(R.id.recommendbtn);

            recommend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(BmiActivity.this, Overweight.class);
                    startActivity(intent);


                }
            });
        }
        else{
            mcategoryDisplay.setText("Obese");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);

            recommend = findViewById(R.id.recommendbtn);

            recommend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(BmiActivity.this, Obese.class);
                    startActivity(intent);


                }
            });
        }

        mgenderDisplay.setText(intent.getStringExtra("gender"));
        mbmiDisplay.setText(mbmi);




        recalculateBmi = findViewById(R.id.recalculateBmibtn);

        recalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BmiActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });





    }
}