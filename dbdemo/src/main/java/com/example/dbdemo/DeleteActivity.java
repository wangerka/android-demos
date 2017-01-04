package com.example.dbdemo;

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

public class DeleteActivity extends AppCompatActivity {

    private EditText nameEt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_activity);

        nameEt = (EditText) findViewById(R.id.name);
    }

    public void deleteByName(View view){
        BookDatabaseHelper helper = new BookDatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("book_table", "name = ?", new String[]{nameEt.getText().toString()});

        Toast.makeText(this, "delete sucess!", Toast.LENGTH_SHORT).show();

        finish();
    }
}
