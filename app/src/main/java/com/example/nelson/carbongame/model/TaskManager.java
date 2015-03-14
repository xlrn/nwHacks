package com.example.nelson.carbongame.model;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Created by Jennifer on 2015-03-14.
 */
public class TaskManager {

    private HashMap<String, ArrayList<Integer>> availTasks;

    private static TaskManager instance = null;

    public static TaskManager getInstance() {
        if (instance == null)
            instance = new TaskManager();
        return instance;
    }


    protected TaskManager() {
        ArrayList<Integer> light = new ArrayList();
        light.add(300);
        light.add(-1);
        availTasks.put("light", light);

        ArrayList<Integer> electronics = new ArrayList();
        electronics.add(300);
        electronics.add(-1);
        availTasks.put("electronics", electronics);

        ArrayList<Integer> appliances = new ArrayList();
        appliances.add(180);
        appliances.add(-3);
        availTasks.put("appliances", appliances);

        ArrayList<Integer> car = new ArrayList();
        car.add(0);
        car.add(-10);
        availTasks.put("car", car);

        ArrayList<Integer> water = new ArrayList();
        water.add(270);
        water.add(-6);
        availTasks.put("water", water);

        ArrayList<Integer> bus = new ArrayList();
        bus.add(0);
        bus.add(3);
        availTasks.put("bus", bus);

        ArrayList<Integer> bike = new ArrayList();
        bike.add(0);
        bike.add(5);
        availTasks.put("bike", bike);

        ArrayList<Integer> walk = new ArrayList();
        walk.add(0);
        walk.add(6);
        availTasks.put("walk", walk);

        ArrayList<Integer> paper = new ArrayList();
        
        paper.add(1);
        availTasks.put("paper", paper);

        ArrayList<Integer> cans = new ArrayList();

        cans.add(2);
        availTasks.put("cans", cans);

        ArrayList<Integer> plant = new ArrayList();

        plant.add(5);
        availTasks.put("plant", plant);
    }

    public ArrayList<Integer> getList(String name) {
        return availTasks.get(name);
    }
}
