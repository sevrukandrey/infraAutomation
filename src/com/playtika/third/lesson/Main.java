package com.playtika.third.lesson;

import org.assertj.core.util.Maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String s = "asd\n\r\t";
        System.out.println(s.length());
    }

    public static Map<String, Integer> getFrequencies(String text) {

        if (text == null) {
            throw new RuntimeException();
        }
          return new HashMap<>();
    }
}
