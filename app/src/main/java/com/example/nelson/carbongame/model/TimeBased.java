package com.example.nelson.carbongame.model;

import com.example.nelson.carbongame.UI.Timer;


/**
 * Created by Jennifer on 2015-03-13.
 */
public class TimeBased {
    private static int lightRate = -1;
    private static int elecRate = -2;
    private static int appRate = -3;
    private static int waterRate = -6;
    private static int carRate = -10;
    private static int walkRate = 6;
    private static int busRate = 3;
    private static int bikeRate = 5;

    public static int getElecRate() {
        return elecRate;
    }

    public static int getAppRate() {
        return appRate;
    }

    public static int getWaterRate() {
        return waterRate;
    }

    public static int getCarRate() {
        return carRate;
    }

    public static int getWalkRate() {
        return walkRate;
    }

    public static int getBusRate() {
        return busRate;
    }

    public static int getBikeRate() {
        return bikeRate;
    }

    public static int getLightRate() {
        return lightRate;

    }

    public static int calcScore(int timePassed, int rate) {
        return (rate * timePassed);
    }
}
