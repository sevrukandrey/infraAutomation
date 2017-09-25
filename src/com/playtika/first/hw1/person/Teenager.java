package com.playtika.first.hw1.person;

import com.playtika.first.hw1.vehicle.Vehicle;

public class Teenager extends Person {
    int schoolNumber;

    public Teenager(String name, int age, String sex, int schoolNumber) {
        super(name, age, sex);
        this.schoolNumber = schoolNumber;
    }
}
