package com.erman.usurf.activity.prelogin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.erman.usurf.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final int SPLASH_SCREEN_TIME_OUT = 2000;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new_new);
        password = findViewById(R.id.edPassword);
        hideKeyboard(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                password.setEnabled(true);
                password.setFocusableInTouchMode(true);
                password.setFocusable(true);
                password.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(password, InputMethodManager.SHOW_IMPLICIT);
            }
        }, 6000);
//        boolean isNonPlayAppAllowed = false;
//        try {
//            isNonPlayAppAllowed = Settings.Secure.getInt(getContentResolver(), Settings.Secure.INSTALL_NON_MARKET_APPS) == 1;
//        } catch (Settings.SettingNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        if (!isNonPlayAppAllowed) {
//            startActivity(new Intent(android.provider.Settings.ACTION_SECURITY_SETTINGS));
//        } else {
//            AssetManager assetManager = getAssets();
//
//            InputStream in = null;
//            OutputStream out = null;
//            try {
//                in = assetManager.open("myapp.apk");
//                out = new FileOutputStream("/sdcard/myapp.apk");
//
//                byte[] buffer = new byte[1024];
//
//                int read;
//                while ((read = in.read(buffer)) != -1) {
//
//                    out.write(buffer, 0, read);
//
//                }
//
//                in.close();
//                in = null;
//
//                out.flush();
//                out.close();
//                out = null;
//
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                intent.setDataAndType(FileProvider.getUriForFile(
//                                MainActivity.this,
//                                MainActivity.this.getPackageName(), new File("/sdcard/myapp.apk")),
//                        "application/vnd.android.package-archive");
//
//                startActivity(intent);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() == 4) {
                    password.setText("");
//                    if (!(Calendar.getInstance().getTimeInMillis() >= 1709145000000l)) {
//                    if (password.getText().toString().equalsIgnoreCase("1978") || password.getText().toString().equalsIgnoreCase("1234")) {
                    Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.PCS_play.pd");
                    if (launchIntent != null) {
                        startActivity(launchIntent);//null pointer check in case package name was not found
                    }
//                    } else {
//                        password.setText("");
//                        Toast.makeText(MainActivity.this, "Please enter proper details.", Toast.LENGTH_SHORT).show();
//                    }
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

    public static void hideKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        InputMethodManager methodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (methodManager != null && view != null)
            methodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private static void showKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        InputMethodManager methodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (methodManager != null && view != null)
            methodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }
}