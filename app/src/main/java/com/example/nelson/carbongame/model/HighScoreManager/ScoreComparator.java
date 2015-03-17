package com.example.nelson.carbongame.model.HighScoreManager;

import java.util.Comparator;

/**
 * Created by Nelson on 15/03/2015.
 */
public class ScoreComparator implements Comparator<Scores> {
    public int compare(Scores score1, Scores score2) {

        int sc1 = score1.daScore;
        int sc2 = score2.daScore;

        if (sc1 > sc2){
            return -1;
        }else if (sc1 < sc2){
            return +1;
        }else{
            return 0;
        }
    }
}
