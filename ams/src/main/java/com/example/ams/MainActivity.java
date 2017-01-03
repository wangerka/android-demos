package com.example.ams;

import android.app.ActivityManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);

        WindowManager wm = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
    }
}
