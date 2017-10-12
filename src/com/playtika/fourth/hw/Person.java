package com.playtika.fourth.hw;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class Person {

    private String name;
    private double age;
    private String city;

    Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    static OptionalDouble getAverageAges(List<Person> people) {
        return people.stream()
            .filter(Objects::nonNull)
            .mapToDouble(Person::getAge)
            .average();
    }

    static Optional<Person> getOldestPerson(List<Person> people) {
        return people
            .stream()
            .filter(Objects::nonNull)
            .max(comparing(Person::getAge));
    }

    static long countOfDaves(List<Person> people) {
        return people.stream()
            .filter(Objects::nonNull)
            .filter(p -> p.getName().equals("Dave"))
            .count();
    }

    static Map<Double, List<Person>> getPersonByAge(List<Person> people) {
        return people
            .stream()
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(Person::getAge));
    }

    static String getCityWithLargePopulation(List<Person> people) {
        return people
            .stream()
            .filter(Objects::nonNull)
            .filter(p -> p.getCity() != null)
            .collect(
                Collectors.groupingBy(
                    Person::getCity,
                    Collectors.counting()
                )
            )
            .entrySet()
            .stream()
            .max(comparing(Map.Entry::getValue))
            .map(Map.Entry::getKey).orElseThrow(()->new IllegalArgumentException("There is empty person list"));
    }

    static Map<String, Double> averageAgeByCity(List<Person> people) {
        return people.stream()
            .filter(p -> p.getAge() > 18)
            .collect(Collectors.groupingBy(
                Person::getCity,
                Collectors.averagingDouble(Person::getAge)));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", city='" + city + '\'' +
            '}';
    }
}
