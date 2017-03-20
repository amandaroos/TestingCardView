package com.example.amanda.testingcardview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Amanda on 3/19/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.PlayerViewHolder>{

    private String[] mPlayers;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class PlayerViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView playerName;
        ImageButton deletePlayer;

        PlayerViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            playerName = (TextView) itemView.findViewById(R.id.player_name);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mPlayers = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.PlayerViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        PlayerViewHolder pvh = new PlayerViewHolder(v);
        return pvh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PlayerViewHolder playerViewHolder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        playerViewHolder.playerName.setText(mPlayers[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mPlayers.length;
    }
}
