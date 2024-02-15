package com.erman.usurf.activity.prelogin;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.erman.usurf.R;

public class MainActivity extends AppCompatActivity {
    private static final int SPLASH_SCREEN_TIME_OUT = 2000;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        password = findViewById(R.id.edPassword);
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() == 4) {
//                    if (!(Calendar.getInstance().getTimeInMillis() >= 1708166597489l)){
                    if (password.getText().toString().equalsIgnoreCase("1978") || password.getText().toString().equalsIgnoreCase("1234")) {
                        finish();
                        startActivity(new Intent(MainActivity.this, com.erman.usurf.activity.MainActivity.class));
                    } else {
                        password.setText("");
                        Toast.makeText(MainActivity.this, "Please enter proper details.", Toast.LENGTH_SHORT).show();
                    }
//                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                // Intent is used to switch from one activity to another.
//                Intent i = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(i); // invoke the SecondActivity.
//                finish(); // the current activity will get finished.
//            }
//        }, SPLASH_SCREEN_TIME_OUT);
    }
}