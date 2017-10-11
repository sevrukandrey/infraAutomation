package com.playtika.fourth.hw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilesInFolder {

    public Map<String, Long> getWord() throws IOException {
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

    private List<String> getAllLinesFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
