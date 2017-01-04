package com.example.dbdemo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by gejun on 2017/1/3.
 */

public class AddActivity extends AppCompatActivity {

    private EditText authorEt,nameEt,priceEt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        authorEt = (EditText) findViewById(R.id.author);
        nameEt = (EditText) findViewById(R.id.name);
        priceEt = (EditText) findViewById(R.id.price);
    }

    public void submitAndExit(View view){
        BookDatabaseHelper helper = new BookDatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("author", authorEt.getText().toString());
        cv.put("name", nameEt.getText().toString());
        cv.put("price", priceEt.getText().toString());
        db.insert(BookDatabaseHelper.TABLE_BOOK, null, cv);
        //

        Toast.makeText(this, "add success", Toast.LENGTH_SHORT).show();

        finish();
    }
}
