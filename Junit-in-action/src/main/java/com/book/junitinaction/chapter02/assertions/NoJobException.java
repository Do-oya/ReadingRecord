package com.book.junitinaction.chapter02.assertions;

public class NoJobException extends RuntimeException {
    NoJobException(String message) {
        super(message);
    }
}