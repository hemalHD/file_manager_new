package com.erman.usurf.activity.prelogin;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.erman.usurf.R;
import com.erman.usurf.activity.MainActivity;

public class OpenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        findViewById(R.id.btOpen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open the file manager
                startActivity(new Intent(OpenActivity.this, MainActivity.class));
            }
        });
    }

    public static void redirectToPlayStore(Context context) {
        // Redirect to Play Store to download a file manager app
        String appPackageName = "com.google.android.apps.nbu.files"; // Package name of the file manager app
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (ActivityNotFoundException e) {
            // If Play Store app is not available, open Play Store website
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }
}