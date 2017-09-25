package com.playtika.first.lesson;

abstract class Animal  {
    final int age;
    String color;

    Animal(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("age=").append(age);
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
