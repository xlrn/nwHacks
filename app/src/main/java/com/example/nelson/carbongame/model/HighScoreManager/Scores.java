package com.example.nelson.carbongame.model.HighScoreManager;

import com.example.nelson.carbongame.model.Score;

import java.io.Serializable;

/**
 * Created by Nelson on 15/03/2015.
 */
public class Scores implements Serializable {
    int daScore;

    public Scores(int n) {
        daScore = n;
    }

    public int getScores() {
        return daScore;
    }
}
