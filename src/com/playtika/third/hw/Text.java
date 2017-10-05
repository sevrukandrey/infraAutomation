package com.playtika.third.hw;


    import org.junit.Test;

    import java.io.*;
    import java.nio.charset.StandardCharsets;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.nio.file.attribute.BasicFileAttributeView;
    import java.nio.file.attribute.BasicFileAttributes;
    import java.util.*;
    import java.util.concurrent.TimeUnit;

    import static java.nio.file.Files.*;
    import static java.nio.file.Paths.*;
    import static java.util.Objects.requireNonNull;

public class Text {


    private final String text;

    public Text(String text) {
        requireNonNull(text, "Text cant be null");
        this.text = text;
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


    private String getOnlyWordsInlowerCase(String text) {
        String s1 = text.replaceAll("\\p{Punct}", "");
        String s2 = s1.replaceAll("\\p{Digit}", "");
        String s3 = s2.replaceAll("\\p{Space}", " ");
        String s4 = s3.replaceAll("\\s+", " ");
        return s4.trim().toLowerCase();
    }
}


