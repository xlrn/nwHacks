package com.example.nelson.carbongame.model;

/**
 * Created by Jennifer on 2015-03-13.
 */
public class Recycle extends ObjectBased {
    public static int rate;
    public int quantity;
    public Recycle(int rate) {
        this.rate = rate;
    }

    public int calcScore(int quantity) {
        return (rate * quantity);
    }



}
