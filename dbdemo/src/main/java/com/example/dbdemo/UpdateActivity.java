package com.example.dbdemo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.dbdemo.R.id.delete;

/**
 * Created by gejun on 2017/1/3.
 */

public class UpdateActivity extends AppCompatActivity {
    private EditText nameEt, newPriceEt;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);

        nameEt = (EditText)findViewById(R.id.name);
        newPriceEt = (EditText)findViewById(R.id.newprice);

    }

    public void update(View view){
        BookDatabaseHelper helper = new BookDatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("price", newPriceEt.getText().toString());
        db.update("book_table", values, "name = ?", new String[]{nameEt.getText().toString()});

        Toast.makeText(this, "update success!", Toast.LENGTH_SHORT).show();

        finish();
    }
}
