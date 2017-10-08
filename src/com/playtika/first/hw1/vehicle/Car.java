package com.playtika.first.hw1.vehicle;

import com.playtika.first.hw1.person.Person;

public class Car extends Vehicle {
   final int doorCount;



    public Car(TechOptions techOptions, String model,  int doorCount) {
        super(techOptions, model);
        this.doorCount = doorCount;
    }
}
