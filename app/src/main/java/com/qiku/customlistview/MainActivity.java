package com.qiku.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<myListView> mylistView = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listview);
        init();
        myAdapter adapter = new myAdapter(MainActivity.this,R.layout.myitem,mylistView);
        listView.setAdapter(adapter);
    }

    private void init() {
        //myListView listview[10];
        for (int i=0; i<10; i++){
            myListView listview = new myListView(i + " ", R.mipmap.ic_launcher);
            mylistView.add(listview);
        }
    }
}
