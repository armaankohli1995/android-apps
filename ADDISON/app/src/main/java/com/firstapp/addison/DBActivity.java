package com.firstapp.addison;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBActivity {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DBActivity instance;
    public static final String COLUMN_State = "State";
    public static final String COLUMN_Name = "Name";
    public static final String COLUMN_Address = "Address";
    MainActivity mainact;


    /**
     * Private constructor to avoid object creation from outside classes.
     *
     * @param context
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
       // String query = "SELECT " + COLUMN_Name + "," + COLUMN_Address +  " from Book1 where " +
             //   COLUMN_State + "='" + mainact.dealer + "'";
        String query = "SELECT * from Book1 where " +
                COLUMN_State + "='" + mainact.dealer + "'";

        Cursor cursor = database.rawQuery(query, null);
        Log.i("database:", "print");
        // looping through all rows and adding to list
        Log.i("size",cursor.getCount()+"");

        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            if(cursor.getString(cursor.getColumnIndex("State"))!=null){
                dbString += cursor.getString(cursor.getColumnIndex("Name"));
                dbString +=" ";
                dbString += cursor.getString(cursor.getColumnIndex("Address"));
                dbString += "\n";
            }
            cursor.moveToNext();

        }
        return dbString;

    }



}
