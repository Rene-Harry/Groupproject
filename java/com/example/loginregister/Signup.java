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


public class Signup extends AppCompatActivity {

    EditText EditTextfullname;
    EditText Edittextemail;
    EditText Edittextusername;
    EditText Edittextpassword;

    Button signupbtn;
    TextView login_text;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

        EditTextfullname = findViewById(R.id.fullname);
        Edittextusername = findViewById(R.id.username);
        Edittextpassword = findViewById(R.id.password);
        Edittextemail = findViewById(R.id.email);

        signupbtn = findViewById(R.id.signupbtn);
        login_text = findViewById(R.id.login_text);
        progressBar = findViewById(R.id.progress);

        login_text.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();

        });

        signupbtn.setOnClickListener(view -> {

            String fullname, username, email, password;
            fullname = String.valueOf(EditTextfullname.getText());
            username = String.valueOf(Edittextusername.getText());
            email = String.valueOf(Edittextemail.getText());
            password = String.valueOf(Edittextpassword.getText());

            if (!fullname.equals("") && !username.equals("") && !email.equals("") && !password.equals("")) {

                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(() -> {

                    String[] field = new String[4];
                    field[0] = "fullname";
                    field[1] = "username";
                    field[2] = "password";
                    field[3] = "email";

                    String[] data = new String[4];
                    data[0] = fullname;
                    data[1] = username;
                    data[2] = password;
                    data[3] = email;
                    PutData putData = new PutData("http://192.168.43.192/LoginRegister/signup.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {

                            progressBar.setVisibility(View.GONE);
                            String result = putData.getResult();
                            if (result.equals("Sign Up Success")) {
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Login.class);
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




