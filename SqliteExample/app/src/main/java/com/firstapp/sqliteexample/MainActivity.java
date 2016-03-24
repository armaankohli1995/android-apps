package com.firstapp.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;/*
import android.view.Menu;
import android.view.MenuItem;*/

public class MainActivity extends AppCompatActivity {

    EditText buckysInput;
    TextView buckysText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buckysInput = (EditText)findViewById(R.id.buckysInput);
        buckysText = (TextView)findViewById(R.id.buckysText);
        dbHandler = new MyDBHandler(this, null ,null ,1);
        printDatabase();
    }

    //Add a product to the database

    public void addButtonClicked(View view){
        Products product = new Products(buckysInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    //Delete items
    public  void deleteButtonClicked(View view){
        String inputText = buckysInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }


    public void printDatabase(){
        Log.i("db", "entering database");
        String dbString = dbHandler.databasetoString();
        buckysText.setText(dbString);
        buckysInput.setText("");
        Log.i("db", "exiting database");
        Log.i("db", String.valueOf(dbHandler));
    }
}
