package com.example.nelson.carbongame;

import android.os.SystemClock;

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
    public void startTimer() {
        startTime = SystemClock.elapsedRealtime();
    }

    // Get end time
    public void stopTimer() {
        endTime = SystemClock.elapsedRealtime();
    }

    // Get duration in minutes
    public int getDuration() {
        endTime = SystemClock.elapsedRealtime();
        duration = endTime - startTime;
        long tempDur = TimeUnit.MILLISECONDS.toMinutes(duration);
        return (int)tempDur;
    }

    public void setStartTime(long n) {
        startTime = n;
    }

    public void setEndTime(long n) {
        endTime = n;
    }


}
