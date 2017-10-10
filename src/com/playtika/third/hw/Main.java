package com.playtika.third.hw;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        Main m = new Main();
        Map<String,Long> map =  m.getStatistics();

        for (Map.Entry<String, Long> stringLongEntry : map.entrySet()) {
            System.out.println(stringLongEntry);
        }
    }


    String folder = "Files";

        public  Map<String, Long> getStatistics() throws IOException {
            return Files.list(Paths.get("Files"))
                .map(this::getAllLinesFromFile)  //List of String
                .flatMap(Collection::stream)
                .map(s -> s.toLowerCase().split("\\s+"))
                .flatMap(Arrays::stream)
                .filter(w -> w.matches("[a-zA-Z]+"))
                .collect(Collectors
                .groupingBy(
                    Function.identity(),
                    Collectors.counting()
                ));



        }




    private  List<String> getAllLinesFromFile(Path path){
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}


