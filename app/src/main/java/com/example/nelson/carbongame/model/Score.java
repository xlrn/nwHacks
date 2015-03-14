package com.example.nelson.carbongame.model;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by Nelson on 13/03/2015.
 */
public class Score {
    private static int score = 1000;

    public static int getScore() {
        return score;
    }

    public static void setScore(int n) {
        score = n;
    }

    public static void calculateScore(int rate) {
        score = score + rate;
    }

}
