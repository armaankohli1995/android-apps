package com.firstapp.minorproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBActivity {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DBActivity instance;
    public static final String COLUMN_Id = "ID";
    public static final String COLUMN_block = "Block";
    public static final String COLUMN_floor = "floor";


    /**
     * Private constructor to avoid object creation from outside classes.
     *
     * @param
     */

    private DBActivity(Context context) {
        this.openHelper = new DBHandler(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */

    public static DBActivity getInstance(Context context) {
        if (instance == null) {
            instance = new DBActivity(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
        Log.i("hell "," open");
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public String findClass(){

        String dbString="";
        database = openHelper.getWritableDatabase();
        String query = "SELECT " +COLUMN_Id + "," + COLUMN_block + "," + COLUMN_floor + " from DBfinal " +
                "where Day = '" + MainActivity.day + "' and " + MainActivity.time + " = 'no'";

        Cursor cursor = database.rawQuery(query, null);
        Log.i("database:", "print");
        // looping through all rows and adding to list
        Log.i("size",cursor.getCount()+"");

        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            if(cursor.getString(cursor.getColumnIndex("ID"))!=null){
                dbString += cursor.getString(cursor.getColumnIndex("ID"));
                dbString += "  ";
                dbString += cursor.getString(cursor.getColumnIndex("Block"));
                dbString += "  ";
                dbString += cursor.getString(cursor.getColumnIndex("floor"));
                dbString += "\n";
            }
            cursor.moveToNext();

        }
        return dbString;

    }



}
