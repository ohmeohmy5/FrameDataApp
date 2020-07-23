package com.ewgf.cramirez.framedataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] move_names;
    String[] move_inputs;
    String[] move_speeds;
    String[] move_on_blocks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.move_select);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        move_names = res.getStringArray(R.array.move_names);
        move_inputs = res.getStringArray(R.array.move_inputs);
        move_speeds = res.getStringArray(R.array.move_speeds);
        move_on_blocks = res.getStringArray(R.array.move_on_blocks);

        ItemAdapter itemAdapter = new ItemAdapter(this, move_names, move_inputs, move_speeds, move_on_blocks);
        myListView.setAdapter(itemAdapter);
    }
}