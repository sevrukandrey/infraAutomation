package com.playtika.third.hw;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {


        File folder = new File("Files");
        File[] filesFromFolder = folder.listFiles();
        Map<String, Integer> resultMap = new HashMap<>();


        for (File file : filesFromFolder) {
            printInformationAboutFiles(file);
            String testFromFile = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
            Map<String, Integer> wordsFromFile = new Text(testFromFile).getWordFrequencies();
            totalWordsFreq(resultMap, wordsFromFile);
        }

        System.out.println(resultMap);

        File file1 = new File("Files/File1.txt");
        File file2 = new File("Files/File1Copy.txt");
        copyFile(file1, file2);
    }

    private static void totalWordsFreq(Map<String, Integer> resultMap, Map<String, Integer> wordsFromFile) {
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
        System.out.printf("File path : %s, File total space %s, File creation time %s \n", file.getPath(), file.getTotalSpace(), attr1.creationTime());
    }

    private static void copyFile(File fromFile, File toFile) throws IOException {


        try (InputStream in = new FileInputStream(fromFile);
             OutputStream out = new FileOutputStream(toFile);) {

            byte[] buffer = new byte[1024];

            int lineLength;
            while ((lineLength = in.read(buffer)) > 0) {
                out.write(buffer, 0, lineLength);
            }
        }


    }
}

