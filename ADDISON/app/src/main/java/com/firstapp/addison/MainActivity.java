package com.firstapp.addison;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DBActivity dbActivity;
    TextView DispText;
    Spinner StateSpinner;
    public static String dealer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbActivity = DBActivity.getInstance(getApplicationContext());

    }

    public void findDealers(View view){
        DispText = (TextView)findViewById(R.id.DispText);
        StateSpinner = (Spinner)findViewById(R.id.StateSpinner);
        DispText.setMovementMethod(new ScrollingMovementMethod());
        dealer = StateSpinner.getSelectedItem().toString();
        dbActivity.open();
        printDatabase();
        dbActivity.close();
    }

    public void printDatabase(){
        String dbString = dbActivity.findClass();
        DispText.setText(dbString);


    }
}
