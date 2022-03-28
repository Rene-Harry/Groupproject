package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Login extends AppCompatActivity {

    EditText Edittextusername;
    EditText Edittextpassword;

    Button loginbtn;
    TextView signupText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        Edittextusername = findViewById(R.id.username);
        Edittextpassword = findViewById(R.id.password);

        loginbtn = findViewById(R.id.loginbtn);
        signupText = findViewById(R.id.signupText);

        signupText.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), Signup.class);
            startActivity(intent);
            finish();

        });

        loginbtn.setOnClickListener(view -> {

            String  username, password;
            username = String.valueOf(Edittextusername.getText());
            password = String.valueOf(Edittextpassword.getText());

            if (!username.equals("") && !password.equals("")) {

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(() -> {

                    String[] field = new String[2];

                    field[0] = "username";
                    field[1] = "password";


                    String[] data = new String[2];
                    data[0] = username;
                    data[1] = password;


                    PutData putData = new PutData("http://192.168.43.192/LoginRegister/login.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {

                            String result = putData.getResult();
                            if (result.equals("Login Success")) {
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                });
            } else {
                Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
            }

        });


    }
}