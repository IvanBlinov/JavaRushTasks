package com.javarush.task.task29.task2909.car;

/**
 * Created by vanya on 01.03.2017.
 */
public class Truck extends Car {

    public int getMaxSpeed()
    {
        final int MAX_TRUCK_SPEED = 80;
        return MAX_TRUCK_SPEED;
    }

    public Truck(int numberOfPassengers) {
        super(0, numberOfPassengers);
    }
}
