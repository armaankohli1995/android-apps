package com.firstapp.myapplication;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBHandler extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "finaldata.sqlite";
    private static final int DATABASE_VERSION = 1;

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
