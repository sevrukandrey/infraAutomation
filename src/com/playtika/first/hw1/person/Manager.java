package com.playtika.first.hw1.person;

import com.playtika.first.hw1.vehicle.Vehicle;

public class Manager extends Person{

    int salary;

    public Manager(String name, int age, String sex, int salary) {
        super(name, age, sex);
        this.salary = salary;
    }
}
