package com.example.amanda.testingcardview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.addPlayer();
                mAdapter.notifyDataSetChanged();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


                Player[] playerArray = {
                        new Player("Amanda"),
                        new Player("Steven"),
                        new Player("Ivy"),
                        new Player("The General"),
                        new Player("A"),
                        new Player("B"),
                        new Player("C"),
                        new Player("D"),
                        new Player("E"),
                };

                ArrayList<Player> players = new ArrayList<>(Arrays.asList(playerArray));

        mAdapter = new MyAdapter(players);

        mRecyclerView.setAdapter(mAdapter);

    }
}
