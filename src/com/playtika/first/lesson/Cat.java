package com.playtika.first.lesson;


class Cat extends Animal {
    private final String name;

    Cat(int age, String name) {
        super(age);
        this.name = name;
    }

    void call(String command) {
        System.out.println(command + ", " + name);
    }


}
