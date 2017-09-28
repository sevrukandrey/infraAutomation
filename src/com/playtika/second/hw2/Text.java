package com.playtika.second.hw2;

import com.google.common.base.CharMatcher;
import com.google.common.collect.Iterables;
import org.assertj.core.util.Lists;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;

public class Text {
    public String text;

    public Text(String text) {
        this.text = text;
    }



    public List<String> getTopWords(int count, String txt) {

        validateParameters(count, txt);
        String newStr = deleteSpecSymbolsAndNumbersAndSpace(txt);


        Set<String> set = new TreeSet<>();
        StringTokenizer stringTokenizer = new StringTokenizer(newStr, " ");

        while (stringTokenizer.hasMoreTokens()) {
            set.add(stringTokenizer.nextToken());

        }
        Iterable<String> sd = Iterables.limit(set, count);

        return Lists.newArrayList(sd);

    }

    public Map<String, Integer> getWordFrequencies(String text) {

        requireNonNull(text, "Text cant be null");
        String newStr = deleteSpecSymbolsAndNumbersAndSpace(text);

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();


        StringTokenizer stringTokenizer = new StringTokenizer(newStr, " ");

        while (stringTokenizer.hasMoreTokens()) {
            list.add(stringTokenizer.nextToken());
        }

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), Collections.frequency(list, list.get(i)));
        }

        return map;
    }

    public int getLengthInChars(String text) {
        requireNonNull(text, "Text cant be null");
        String newStr = deleteSpecSymbolsAndNumbersAndSpace(text);

        int lenght = 0;

        List<String> list = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(newStr, " ");

        while (stringTokenizer.hasMoreTokens()) {
            list.add(stringTokenizer.nextToken());
        }

        for (String aList : list) {
            lenght += aList.length();
        }


        return lenght;
    }


    private void validateParameters(int count, String txt) {
        requireNonNull(txt, "Text cant be null");

        if (count < 0) {
            throw new RuntimeException("count can not be < 0");
        }
    }

    private String deleteSpecSymbolsAndNumbersAndSpace(String text) {
        String s1 = text.replaceAll("\\p{Punct}", "");
        String s2 = s1.replaceAll("\\p{Digit}", "");
        String s3 = s2.replaceAll("\\s+", " ");
        return s3;
    }

}
