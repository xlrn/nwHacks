package com.example.nelson.carbongame.model;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;


/**
 * Created by Nelson on 13/03/2015.
 */
public class Score implements Serializable {
    private static int score = 1000;

    public static int getScore() {
        return score;
    }

    public static void setScore(int n) {
        score = n;
    }

    public static void calculateScore(int newScore) {
        score = score + newScore;
    }

}
