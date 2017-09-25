package com.playtika.first.hw1;

import com.playtika.first.hw1.person.Manager;
import com.playtika.first.hw1.person.Person;
import com.playtika.first.hw1.vehicle.Car;
import com.playtika.first.hw1.vehicle.TechOptions;
import com.playtika.first.hw1.vehicle.Vehicle;

public class Main {

    public static void main(String[] args) {

        Person manager = new Manager("David",45, "man",2000);

        TechOptions bmwOpt = new TechOptions();
        bmwOpt.price =20000;
        bmwOpt.color= "red";
        bmwOpt.maxSpeed = 200;

        Vehicle bmw = new Car(bmwOpt, "bmw", 5);

        bmw.drive(manager);
    }
}
