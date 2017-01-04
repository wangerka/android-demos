package com.example.myapplication;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    StringBuilder sb;
    private TextView text;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb = new StringBuilder();
        text = (TextView)findViewById(R.id.text);

        cursor = getContentResolver().query(Uri.parse("content://com.example.dbdemo.provider/book_table"), null, null, null, null);
        if(cursor != null){
            while(cursor.moveToNext()){
                sb.append("author = " + cursor.getString(cursor.getColumnIndex("author"))
                        +", name = " + cursor.getString(cursor.getColumnIndex("name"))
                        +", price = " + cursor.getString(cursor.getColumnIndex("price"))+"\n");
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        cursor.close();
        text.setText(sb.toString());
    }
}
