package com.playtika.third.hw;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {


        File folder = new File("Files");
        File[] listOfFiles = folder.listFiles();
        Map<String, Integer> resultMap = new HashMap<>();


        for (File listOfFile : listOfFiles) {
            printInformationAboutFiles(listOfFile);
            String file = new String(Files.readAllBytes(Paths.get(listOfFile.getPath())), StandardCharsets.UTF_8);
            HashMap<String, Integer> wordsFromFile = new HashMap<>(new Text(file).getWordFrequencies());
            totalWordsFreq(resultMap, wordsFromFile);
        }

        System.out.println(resultMap);

        File file1 = new File("Files/File1.txt");
        File file2 = new File("Files/File1Copy.txt");
        copyFile(file1, file2);
    }

    private static void totalWordsFreq(Map<String, Integer> resultMap, HashMap<String, Integer> wordsFromFile) {
        for (Map.Entry<String, Integer> entry : wordsFromFile.entrySet()) {
            Integer currentWordFreq = resultMap.get(entry.getKey());
            if (currentWordFreq != null) {
                int totalFreq = entry.getValue() + currentWordFreq;
                resultMap.put(entry.getKey(), totalFreq);
            } else {
                resultMap.put(entry.getKey(), entry.getValue());
            }

        }
    }

    private static void printInformationAboutFiles(File file) throws IOException {
        BasicFileAttributes attr1 = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        System.out.println("File path : " + file.getPath() + " File total space : " + file.getTotalSpace() + "  file creation time : " + attr1.creationTime());
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
}

