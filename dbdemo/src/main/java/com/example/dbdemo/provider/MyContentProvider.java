package com.example.dbdemo.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.example.dbdemo.BookDatabaseHelper;

/**
 * Created by gejun on 2017/1/4.
 */

public class MyContentProvider extends ContentProvider {
    public static final String AUTHORITY = "com.example.dbdemo.provider";

    public static UriMatcher um;
    public static final int BOOKS = 0;
    public static final int BOOKS_ID = 1;

    static {
        um = new UriMatcher(UriMatcher.NO_MATCH);
        um.addURI(AUTHORITY, "book_table", BOOKS);
        um.addURI(AUTHORITY, "book_table/#", BOOKS_ID);
    }
    @Nullable
    @Override
    public String getType(Uri uri) {
        switch(um.match(uri)){
            case BOOKS:
                return "vnd.android.cursor.dir/book_table";
            case BOOKS_ID:
                return "vnd.android.cursor.item/book_table";
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    private SQLiteDatabase db;
    private BookDatabaseHelper helper;

    @Override
    public boolean onCreate() {
        helper = new BookDatabaseHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        db = helper.getWritableDatabase();
        switch(um.match(uri)){
            case BOOKS:
                return db.query("book_table", projection, selection, selectionArgs, null, null, sortOrder);
            case BOOKS_ID:
                String id = uri.getPathSegments().get(1);
                return db.query("book_table", projection, "_id = ?", new String[]{id}, null, null, sortOrder);
        }
        return null;
    }
}
