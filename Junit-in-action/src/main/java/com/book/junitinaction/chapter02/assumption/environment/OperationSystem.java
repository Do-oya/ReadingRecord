package com.book.junitinaction.chapter02.assumption.environment;

public class OperationSystem {
    private String name;
    private String architecture;

    public OperationSystem(String name, String architecture) {
        this.name = name;
        this.architecture = architecture;
    }

    public String getName() {
        return name;
    }

    public String getArchitecture() {
        return architecture;
    }
}