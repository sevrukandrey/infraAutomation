package com.playtika.first.lesson;

/**
 * Created by Home-pc on 18.09.2017.
 */
public class Application {
    public static void main(String[] args) {
        Cat tom = new Cat(5, "tom");
        tom.color = "red";

        System.out.println(tom.toString());

        print(tom);





    }

    private static void print(Animal animal) {
        System.out.println(animal);
    }
}
