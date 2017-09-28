package com.playtika.second.hw2;

public class Application {
    public  int countOfWords(String text){
        if (text == null) {
            throw new RuntimeException("text can`t be null");
        }
        if (text.isEmpty()) {
            return 0;
        }
        return  text.split(" ").length;
    }
}
