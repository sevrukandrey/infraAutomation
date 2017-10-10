package com.playtika.fourth.hw;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class Person {

    private String name;
    private double age;
    private String city;

    Person() {
    }

    Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    double getAverageAges(List<Person> persons) {
        return persons.stream()
            .filter(Objects::nonNull)
            .mapToDouble(Person::getAge)
            .average()
            .getAsDouble();
    }

    Optional<Person> getOldestPerson(List<Person> persons) {
        return persons
            .stream()
            .filter(Objects::nonNull)
            .max(comparing(Person::getAge));
    }

    long countOfDaves(List<Person> persons) {
        return persons.stream()
            .filter(Objects::nonNull)
            .filter(p -> p.getName().equals("Dave"))
            .count();
    }

    Map<Double, List<Person>> getPersonByAge(List<Person> persons) {
        return persons
            .stream()
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(Person::getAge));
    }

    String getCityWithLargePopulation(List<Person> persons) {
        return persons
            .stream()
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
            .get().getKey();
    }

    Map<String, Double> averageAgeByCity(List<Person> person) {
        return person.stream()
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
