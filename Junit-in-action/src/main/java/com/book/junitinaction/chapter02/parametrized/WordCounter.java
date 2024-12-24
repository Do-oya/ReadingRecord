package com.book.junitinaction.chapter02.parametrized;

public class WordCounter {
    public int countWords(String sentence) {
        return sentence.split(" ").length;
    }
}
