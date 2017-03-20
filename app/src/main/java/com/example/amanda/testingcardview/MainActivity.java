package com.example.amanda.testingcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> mPlayerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                String[] playerNames = {"Amanda","Steven", "Ivy", "The General"};

        mPlayerAdapter = new ArrayAdapter<String>(this,R.layout.list_item, R.id.player_name, playerNames);

        ListView playerList = (ListView) findViewById(R.id.list_view);
        playerList.setAdapter(mPlayerAdapter);

    }
}
