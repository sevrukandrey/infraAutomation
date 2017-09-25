package com.playtika.first.hw1.person;

import com.playtika.first.hw1.vehicle.Vehicle;

public class Person {



    private final String name;
    private String sex;
    private int age;
    private Vehicle vehicle;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getName() {
        return name;
    }



}
