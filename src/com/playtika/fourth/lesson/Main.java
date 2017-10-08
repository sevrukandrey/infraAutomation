package com.playtika.fourth.lesson;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        Optional<String> name = findUserName(-1);
        //lamda parameter -> {block of code} -- parametr <String>.

        //Optional doent use for Collection, collection has method isEmpty;

       // .map доступ к лементу
        //flatmap


       Integer length =  name.map(String::length).orElseGet(() -> getDefaultLength());

        System.out.println(length);
        /**********************************************************/

        List<String> words = new ArrayList<>(asList("aaaa", "asd", "a"));
        List<Integer> filtred = words.stream()
                .filter((word) -> (word.length() > 2))
                .map(String::length)
                .limit(3)
                .collect(toList());
                //reduce (0, (a,b) -> a+b) Sum of element return int for object
        ///Can use sum if used IntStrem

IntStream.range(0,10).sum();


    }





    private static Integer getDefaultLength() {
        return 0;
    }

    private static Optional<String> findUserName(long id) {
        if (id < 0){
            return Optional.empty();
        }
        return Optional.of("default");
    }


}
