package com.playtika.fourth.hw;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

class Text {
    private final String text;

    Text(String text) {
        requireNonNull(text, "Text cant be null");
        this.text = text;
    }


    List<String> getTopWords(int returnedCountOfTopWords) {

        if (returnedCountOfTopWords <= 0) {
            throw new IllegalArgumentException("returnedCountOfTopWords can not be 0 or less");
        }
        String cleanedText = getOnlyWordsInlowerCase(text);

        return Stream.of(cleanedText.split(" "))
                .distinct()
                .sorted()
                .limit(returnedCountOfTopWords)
                .collect(toList());
    }

    Map<String, Long> getWordFrequencies() {
        Map<String, Long> frequencies = new HashMap<>();
        String cleanedText = getOnlyWordsInlowerCase(text);

        if (cleanedText.isEmpty()) {
            return frequencies;
        }

        return Stream.of(cleanedText.split(" "))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())
                );
    }

    int getLengthInChars() {
        String cleanedText = getOnlyWordsInlowerCase(text);

        return Arrays.stream(cleanedText.split(" "))
                .mapToInt(String::length)
                .sum();
    }


    private String getOnlyWordsInlowerCase(String text) {
        String s1 = text.replaceAll("\\p{Punct}", "");
        String s2 = s1.replaceAll("\\p{Digit}", "");
        String s3 = s2.replaceAll("\\s+", " ");
        return s3.trim().toLowerCase();
    }
}
