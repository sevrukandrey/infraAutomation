package com.playtika.second.hw2;


import com.google.common.collect.Iterables;
import org.assertj.core.util.Lists;

import java.util.*;

import static java.util.Objects.requireNonNull;

public class Text {
    public final String text;

    public Text(String text) {
        requireNonNull(text, "Text cant be null");
        this.text = text;
    }


    public List<String> getTopWords(int count) {

        if (count <= 0) {
            throw new RuntimeException("count can not be 0 or less");
        }

        String newStr = getOnlyWordsInlowerCase(text);

        Set<String> set = new TreeSet<>(Arrays.asList(newStr.split(" ")));


        Iterable<String> sd = Iterables.limit(set, count);

        return Lists.newArrayList(sd);

    }

    public Map<String, Integer> getWordFrequencies() {
        Map<String, Integer> map = new HashMap<>();
        String newStr = getOnlyWordsInlowerCase(text);

        if (newStr.isEmpty()) {
            return map;
        }

        List<String> list = new ArrayList<>(Arrays.asList(newStr.split(" ")));

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), Collections.frequency(list, list.get(i)));
        }

        return map;
    }

    public int getLengthInChars() {
        String newStr = getOnlyWordsInlowerCase(text);

        int length = 0;

        List<String> list = new ArrayList<>(Arrays.asList(newStr.split(" ")));

        for (String aList : list) {
            length += aList.length();
        }

        return length;
    }


    private String getOnlyWordsInlowerCase(String text) {
        String s1 = text.replaceAll("\\p{Punct}", "");
        String s2 = s1.replaceAll("\\p{Digit}", "");
        String s3 = s2.replaceAll("\\s+", " ");
        return s3.trim().toLowerCase();
    }
}
