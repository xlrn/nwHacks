package com.example.nelson.carbongame.UI;

import java.util.concurrent.TimeUnit;

/**
 * Created by Nelson on 13/03/2015.
 */
public class Timer {
    protected long startTime;
    protected long endTime;
    protected long duration;


    // CONSTRUCTOR
    public Timer() {
       startTime = 0;
       endTime = 0;
       duration = 0;
    }

    // Get starting time
    protected void startTimer() {
        startTime = System.currentTimeMillis();
    }

    // Get end time
    protected void stopTimer() {
        endTime = System.currentTimeMillis();
    }

    // Get duration in minutes
    protected int getDuration() {
        duration = endTime - startTime;
        long tempDur = TimeUnit.MILLISECONDS.toMinutes(duration);
        return (int)tempDur;
    }


}
