package com.example.amanda.testingcardview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * CustomAdapter for recycling the player card views
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.PlayerViewHolder>{

    private ArrayList<Player> mPlayers;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class PlayerViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView playerName;
        ImageButton deletePlayerButton;

        PlayerViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            playerName = (TextView) itemView.findViewById(R.id.player_name);
            deletePlayerButton = (ImageButton) itemView.findViewById(R.id.delete_player_button);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<Player> myDataset) {
        mPlayers = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.PlayerViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        PlayerViewHolder pvh = new PlayerViewHolder(v);
        return pvh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final PlayerViewHolder playerViewHolder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        playerViewHolder.playerName.setText(mPlayers.get(position).getName());
        playerViewHolder.deletePlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayers.remove(playerViewHolder.getAdapterPosition());
                notifyDataSetChanged();

            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mPlayers.size();
    }

    public void addPlayer(){
        mPlayers.add(new Player("New Player"));
    }
}
