package com.playtika.third.hw;


import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.nio.file.Files.*;
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
        String s3 = s2.replaceAll("\\p{Space}", " ");
        String s4 = s3.replaceAll("\\s+", " ");
        return s4.trim().toLowerCase();
    }


    public static void main(String[] args) throws IOException {

        String file1 = new String(Files.readAllBytes(Paths.get("Files/File1.txt")), StandardCharsets.UTF_8);
        String file2 = new String(Files.readAllBytes(Paths.get("Files/File2.txt")), StandardCharsets.UTF_8);
        String file3 = new String(Files.readAllBytes(Paths.get("Files/File3.txt")), StandardCharsets.UTF_8);

        Map<String, Integer> map1 = new Text(file1).getWordFrequencies();
        Map<String, Integer> map2 = new Text(file2).getWordFrequencies();
        Map<String, Integer> map3 = new Text(file3).getWordFrequencies();

        int sumOfValuesFrequency1 = countValuesOfMap(map1);
        int sumOfValuesFrequency2 = countValuesOfMap(map2);
        int sumOfValuesFrequency3 = countValuesOfMap(map3);

        System.out.println(sumOfValuesFrequency1 + sumOfValuesFrequency2 + sumOfValuesFrequency3);

        printInformationAboutFiles();



        File from = new File("Files/File1.txt");
        File to = new File("Files/copy.txt");
        copyFile(from, to);

    }

    private static void copyFile(File fromFile, File toFile) throws IOException {


        try (InputStream inputStream = new FileInputStream(fromFile);
             OutputStream outputStream = new FileOutputStream(toFile);) {

            byte[] buffer = new byte[1024];

            int lineLength;
            while ((lineLength = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, lineLength);
            }
        }

    }

    private static void printInformationAboutFiles() throws IOException {
        File file1 = new File("Files/File1.txt");
        File file2 = new File("Files/File2.txt");
        File file3 = new File("Files/File3.txt");

        BasicFileAttributes  attr1 = Files.readAttributes(file1.toPath(), BasicFileAttributes.class);
        BasicFileAttributes  attr2 = Files.readAttributes(file2.toPath(), BasicFileAttributes.class);
        BasicFileAttributes  attr3 = Files.readAttributes(file3.toPath(), BasicFileAttributes.class);


        System.out.println("File1 path : " + file1.getPath() + " File1 total space : "+ file1.getTotalSpace() + "  file1 creation time : " +attr1.creationTime());
        System.out.println("File2 path : " + file2.getPath() + " File2 total space : "+ file2.getTotalSpace() + "  file2 creation time : " +attr2.creationTime());
        System.out.println("File2 path : " + file3.getPath() + " File3 total space : " + file3.getTotalSpace() + "  file3 creation time : " +attr3.creationTime());


    }

    private static int countValuesOfMap(Map<String, Integer> map) {
        int freq = 0;
        for (Integer values : map.values()) {
            freq = freq + values;
        }
        return freq;

    }


}
