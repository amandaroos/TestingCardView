package com.example.amanda.testingcardview;

/**
 * Player class stores player name and score
 */

public class Player {

    public String mName;
    public int mScore = 0;

    public Player (String name){
        mName = name;
    }

    public String getName(){
        return mName;
    }


}
