package com.playtika.fourth.hw;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;
    private String city;

    Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
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

    double getAverageAges(List<Person> persons) {
        return persons.stream()
                .filter(Objects::nonNull)
                .mapToDouble(p -> p.age)
                .average()
                .getAsDouble();
    }

    Optional<Person> getOldestPerson(List<Person> persons) {
        return persons.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Person::getAge));
    }

    long countOfDaves(List<Person> persons) {
        return persons.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getName().equals("Dave"))
                .count();
    }

    Map<Integer, List<Person>> getPersonByAge(List<Person> persons) {
        return persons
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Person::getAge));
    }

    public static void main(String[] args) {
        Person p = new Person();
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("andrey", 20, "borispol"));
        persons.add(new Person("andrey", 18, "borispol"));
        persons.add(new Person("katja", 30, "becyk"));
        persons.add(new Person("sveta", 102, "kiev"));
        persons.add(new Person("sveta", 150, "kiev"));
        Map<String, Double> averageAgeByCity = p.averageAgeByCity(persons);
        for (Map.Entry<String, Double> stringListEntry : averageAgeByCity.entrySet()) {
            System.out.println(stringListEntry);
        }

        String str = p.getCityWithLargePopulation(persons);
        System.out.println(str);
    }

    String getCityWithLargePopulation(List<Person> persons) {
         return persons.stream()
                 .collect(
                         Collectors.groupingBy(
                        Person::getCity,
                        Collectors.counting()
                        )
                )
                 .entrySet()
                 .stream()
                 .max(Comparator.comparing(entry -> entry.getKey()))
                 .get().getKey();
    }

    Map<String, Double> averageAgeByCity(List<Person> person) {
        return person.stream()
                .filter(p -> p.age > 18)
                .collect(Collectors.groupingBy(
                        Person::getCity,
                        Collectors.averagingDouble(Person::getAge)));
    }

}
