package com.example.loginregister;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button calculatebmi;

    TextView mcurrentHeight;
    TextView mcurrentAge;
    TextView mcurrentWeight;

    ImageView mincrementAge;
    ImageView mincrementWeight;
    ImageView mdecrementAge;
    ImageView mdecrementWeight;

    SeekBar mseekBarHeight;

    RelativeLayout mmale;
    RelativeLayout mfemale;

    int intWeight=86;
    int intAge=21;
    int currentProgress;
    String mintProgress="170";
    String typeOfUser="0";
    String weight="86";
    String age2="21";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        calculatebmi = findViewById(R.id.calculateBmibtn);
        mcurrentAge = findViewById(R.id.currentAge);
        mcurrentHeight = findViewById(R.id.currentHeight);
        mcurrentWeight = findViewById(R.id.currentWeight);
        mincrementAge = findViewById(R.id.incrementAge);
        mincrementWeight = findViewById(R.id.incrementWeight);
        mdecrementAge = findViewById(R.id.decrementAge);
        mdecrementWeight = findViewById(R.id.decrementWeight);
        mseekBarHeight = findViewById(R.id.seekBarHeight);
        mmale = findViewById(R.id.male);
        mfemale = findViewById(R.id.female);


        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalecardfocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalecard));
                typeOfUser="Male";
            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalecardfocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalecard));
                typeOfUser="Female";

            }
        });


        mseekBarHeight.setMax(272);
        mseekBarHeight.setProgress(170);
        mseekBarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentProgress=i;
                mintProgress=String.valueOf(currentProgress);
                mcurrentHeight.setText(mintProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mseekBarHeight.setMin(55);

        mincrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intAge=intAge+1;
                age2=String.valueOf(intAge);
                mcurrentAge.setText(age2);
            }
        });

        mdecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intAge=intAge-1;
                age2=String.valueOf(intAge);
                mcurrentAge.setText(age2);
            }
        });

        mincrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intWeight=intWeight+1;
                weight=String.valueOf(intWeight);
                mcurrentWeight.setText(weight);
            }
        });

        mdecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intWeight=intWeight-1;
                weight=String.valueOf(intWeight);
                mcurrentWeight.setText(weight);
            }
        });




        calculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(typeOfUser.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select gender First", Toast.LENGTH_SHORT).show();
                }
                else if (mintProgress.equals("0")){
                    Toast.makeText(getApplicationContext(), "Set Height First", Toast.LENGTH_SHORT).show();
                }
                else if (intAge==0 || intAge<0){
                    Toast.makeText(getApplicationContext(), "Incorrect Age", Toast.LENGTH_SHORT).show();
                }
                else if (intWeight==0 || intWeight<0){
                    Toast.makeText(getApplicationContext(), "Incorrect Weight", Toast.LENGTH_SHORT).show();
                }
                else {

                    Intent intent = new Intent(MainActivity.this, BmiActivity.class);
                    intent.putExtra("gender", typeOfUser);
                    intent.putExtra("height", mintProgress);
                    intent.putExtra("weight", weight);
                    intent.putExtra("age", age2);

                    startActivity(intent);

                }
            }
        });
    }
}