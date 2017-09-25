package com.playtika.first.hw1.vehicle;


import com.playtika.first.hw1.person.Person;

public class Vehicle {

    private TechOptions techOptions;
    private String model;

    public Vehicle(TechOptions techOptions, String model) {
        this.techOptions = techOptions;
        this.model = model;
    }

    public void drive(Person person){
        System.out.println(person.getName() + " drive " + model + " with max speed : " + techOptions.maxSpeed);
    }


}
