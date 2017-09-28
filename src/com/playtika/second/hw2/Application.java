package com.playtika.second.hw2;

public class Application {
    public  int countOfWords(String text){
        if (text == null) {
            throw new RuntimeException("text can`t be null");
        }
        if (text.isEmpty()) {
            return 0;
        }
       String resultString = deleteAllSpecificSymbolsAndSpace(text);
        return  resultString.split(" ").length;
    }

    private String deleteAllSpecificSymbolsAndSpace(String text) {
        String newTxt = text.replaceAll("\\p{Punct}", "");
        return newTxt.replaceAll("\\s+", " ").trim();
    }
}
