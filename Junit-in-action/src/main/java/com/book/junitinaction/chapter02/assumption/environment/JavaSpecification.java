package com.book.junitinaction.chapter02.assumption.environment;

public class JavaSpecification {
    private String version;

    public JavaSpecification(String version) {
        this.version = version;
    }

    String getVersion() {
        return version;
    }
}