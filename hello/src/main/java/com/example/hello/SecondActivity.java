package com.example.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by gejun on 2016/12/29.
 */

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Log.i("gejun", "SecondActivity-onCreate"+this);
    }

    public void start(View view){
        startActivity(new Intent(this, ThirdActivity.class));
    }
}
