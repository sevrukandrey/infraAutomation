package com.playtika.fourth.hw;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;


public class PersonTest {
    @Test
    public void shouldReturnAverageAge() {
        Person p = new Person();
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("a", 10, "b"));
        persons.add(new Person("a", 0, "b"));
        assertThat(p.getAverageAges(persons)).isEqualTo(5.0);
    }

    @Test
    public void shouldReturnAverageAgeForNullPerson() {
        Person p = new Person();
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("a", 10, "b"));
        persons.add(null);
        assertThat(p.getAverageAges(persons)).isEqualTo(10);
    }

    @Test
    public void shouldReturnOldestPerson() {
        Person p = new Person();
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("a", 10, "b"));
        persons.add(new Person("a", 100, "b"));
        assertThat(p.getOldestPerson(persons)).contains(persons.get(1));
    }

    @Test
    public void shouldReturnCountOfDaves() {
        Person p = new Person();
        List<Person> persons = new ArrayList<>();
        persons.add(null);
        persons.add(new Person("a", 100, "b"));
        persons.add(new Person("Dave", 100, "b"));
        persons.add(new Person("dave", 100, "b"));
        assertThat(p.countOfDaves(persons)).isEqualTo(1);
    }

    @Test
    public void shouldSplitByAge() {
        Person p = new Person();
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Andrey", 100, "b"));
        persons.add(new Person("Bory", 100, "b"));
        persons.add(new Person("Vasya", 12, "b"));
        assertThat(p.getPersonByAge(persons)).isEqualTo(1);
    }


}
