package com.example.nelson.carbongame.model;

/**
 * Created by Jennifer on 2015-03-13.
 */
public class Transit extends TimeBased {
    public static int rate;
    public static int init;
    public Transit(int rate, int init) {
        this.rate = rate;
        this.init = init;
    }

    public int calcScore(int timePassed) {
        return (init + rate * timePassed);
    }
}
