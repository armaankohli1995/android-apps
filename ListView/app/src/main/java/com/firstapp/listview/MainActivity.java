package com.firstapp.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] foods = {"Bacon", "Ham", "Toona", "Candy", "Meatball", "Potato","a","b","c","d","e"};
        ListAdapter buckysAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, foods);
        ListView buckysListView = (ListView) findViewById(R.id.buckysListView);
        buckysListView.setAdapter(buckysAdapter);

        buckysListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                         String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this,food,Toast.LENGTH_LONG).show();
                    }
                }

        );
    }

}
