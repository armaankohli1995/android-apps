package com.firstapp.minorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    public static String day;
    public static String time;
    Spinner daySpinner;
    Spinner timeSpinner;
    TextView DBDisplayText;
    DBActivity dbActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbActivity = DBActivity.getInstance(getApplicationContext());

    }

    public void onClickFindClass(View view){
        daySpinner = (Spinner)findViewById(R.id.daySpinner);
        timeSpinner = (Spinner)findViewById(R.id.timeSpinner);
        DBDisplayText = (TextView)findViewById(R.id.DBDisplayText);

        DBDisplayText.setMovementMethod(new ScrollingMovementMethod());

        day = daySpinner.getSelectedItem().toString();
        time = timeSpinner.getSelectedItem().toString();

        Log.i("Day:", day);
        Log.i("Time: ", time);


       dbActivity.open();
        printDatabase();
        dbActivity.close();
    }


    public void printDatabase(){
        String dbString = dbActivity.findClass();
        DBDisplayText.setText(dbString);


    }
}
