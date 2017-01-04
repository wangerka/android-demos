package com.example.dbdemo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private BookDatabaseHelper helper;
    private SQLiteDatabase db;

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new BookDatabaseHelper(this);
        list = (ListView)findViewById(R.id.list);
        query();
    }

    public void createDb(View view){
        db = helper.getWritableDatabase();
    }

    public void toAddActivity(View view){
        startActivity(new Intent(this, AddActivity.class));
    }

    public void toUpdateActivity(View view){
        startActivity(new Intent(this, UpdateActivity.class));
    }

    public void toDeleteActivity(View view){
        startActivity(new Intent(this, DeleteActivity.class));
    }

    public void queryAll(View view){
        query();
    }

    private void query(){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query("book_table", null, null, null, null, null, null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_item, cursor,
                new String[]{"author", "name", "price"},
                new int[]{R.id.author, R.id.name, R.id.price});
        list.setAdapter(adapter);
    }
}
