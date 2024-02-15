package com.erman.usurf.activity.prelogin;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.erman.usurf.R;

public class LoginActivity extends AppCompatActivity {
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        userName = findViewById(R.id.edUsername);
        password = findViewById(R.id.edPassword);
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() == 4) {
                    if (password.getText().toString().equalsIgnoreCase("1978")) {
                        finish();
                        startActivity(new Intent(LoginActivity.this, OpenActivity.class));
                    } else {
                        password.setText("");
                        Toast.makeText(LoginActivity.this, "Please enter proper details.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
//        submit = findViewById(R.id.btSubmit);
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {

//            }
//        });
    }


}