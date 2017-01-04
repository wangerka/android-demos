package com.example.myapplication;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cursor cursor = getContentResolver().query(Uri.parse("content://com.example.dbdemo.provider/book_table/7"), null, null, null, null);
        if(cursor != null){
            while(cursor.moveToNext()){
                Log.i("gejun","author = " + cursor.getString(cursor.getColumnIndex("author"))
                +", name = " + cursor.getString(cursor.getColumnIndex("name"))
                +", price = " + cursor.getString(cursor.getColumnIndex("price")));
            }
        }
    }
}
