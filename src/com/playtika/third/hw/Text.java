package com.playtika.third.hw;


import java.util.*;

import static java.util.Objects.requireNonNull;

public class Text {
    private final String text;

    public Text(String text) {
        requireNonNull(text, "Text cant be null");
        this.text = text;
    }


    public List<String> getTopWords(int returnedCountOfTopWords) {

        if (returnedCountOfTopWords <= 0) {
            throw new IllegalArgumentException("returnedCountOfTopWords can not be 0 or less");
        }

        String cleanedText = getOnlyWordsInlowerCase(text);

        Set<String> words = new TreeSet<>(Arrays.asList(cleanedText.split(" ")));
        if (words.size() < returnedCountOfTopWords) {
            return new ArrayList<>(words);
        }
        return new ArrayList<>(words).subList(0, returnedCountOfTopWords);

    }

    public Map<String, Integer> getWordFrequencies() {
        Map<String, Integer> frequencies = new HashMap<>();
        String cleanedText = getOnlyWordsInlowerCase(text);

        if (cleanedText.isEmpty()) {
            return frequencies;
        }

        List<String> words = Arrays.asList(cleanedText.split(" "));

        for (String word : words) {
            if (frequencies.containsKey(word)) {
                int count = frequencies.get(word) + 1;
                frequencies.put(word, count);
            } else {
                frequencies.put(word, 1);
            }
        }

        return frequencies;
    }

    public int getLengthInChars() {
        String cleanedText = getOnlyWordsInlowerCase(text);

        int length = 0;

        List<String> words = Arrays.asList(cleanedText.split(" "));

        for (String aList : words) {
            length += aList.length();
        }

        return length;
    }


    private String getOnlyWordsInlowerCase(String text) {
        String s1 = text.replaceAll("\\p{Punct}", "");
        String s2 = s1.replaceAll("\\p{Digit}", "");
        String s3 =s2.replaceAll("\\p{Space}", " ");
        String s4 = s3.replaceAll("\\s+", " ");
        return s4.trim().toLowerCase();
    }
}
