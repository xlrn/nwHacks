package com.example.nelson.carbongame.model;

/**
 * Created by Jennifer on 2015-03-13.
 */
public class ObjectBased {
    private static int rate;
    public int quantity;
    public ObjectBased(int rate, int quantity) {
        this.rate = rate;
        this.quantity = quantity;
    }
    public int calcScore() {
        return (rate * quantity);
    }
}
