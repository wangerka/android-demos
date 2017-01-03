package com.example.hello;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("gejun", "MainActivity-onCreate"+this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("gejun", "MainActivity-onSaveInstanceState");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("gejun", "MainActivity-onRestoreInstanceState");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("gejun", "MainActivity-onRestart "+this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("gejun", "MainActivity-onNewIntent");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("gejun", "MainActivity-onConfigurationChanged");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("gejun", "MainActivity-onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("gejun", "MainActivity-onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("gejun", "MainActivity-onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("gejun", "MainActivity-onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("gejun", "MainActivity-onDestroy");
    }

    public void showDialog(View view){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Dialer");
//        builder.setMessage("This is a Dialog!");
//        builder.create().show();
//        startActivity(new Intent(MainActivity.this, SecondActivity.class));
        Intent it= new Intent();
        it.setAction("com.action.second");
        it.addCategory("com.category.second");
        startActivity(it);
    }

}
