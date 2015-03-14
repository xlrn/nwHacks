package com.example.nelson.carbongame.model;

import com.example.nelson.carbongame.UI.Timer;


/**
 * Created by Jennifer on 2015-03-13.
 */
public abstract class TimeBased implements Task {
    private static int rate;
    private static int init;
    private static Timer timer;
    private boolean isOn;
    private String tag;

    public TimeBased(int rate, int init) {
        this.rate = rate;
        this.init = init;
        this.timer = new Timer();
    }



    public int calcScore(int timePassed) {
        return (init + rate * timePassed);
    }
}
