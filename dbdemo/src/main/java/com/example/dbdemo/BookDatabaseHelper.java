package com.example.dbdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by gejun on 2017/1/3.
 */

public class BookDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Book.db";
    private static final int DB_VERSION = 3;
    private Context mContext;
    public static final String TABLE_BOOK = "book_table";

    public BookDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_BOOK + " (" +
                "_id integer primary key autoincrement," +//cant be int
                "author text," +
                "name text," +
                "price float)");
        Toast.makeText(mContext, "onCreate db!", Toast.LENGTH_SHORT).show();
    }

    //Can't downgrade database from version 2 to 1
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(mContext, "onUpgrade db from " + oldVersion + " to " + newVersion,
                Toast.LENGTH_SHORT).show();
    }
}
