package com.study.tobyspring.learningtest.template;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloTest {

    @Test
    void simpleProxy() {
        Hello hello = new HelloTarget();
        assertThat(hello.sayHello("asa")).isEqualTo("Hello asa");
        assertThat(hello.sayHi("asa")).isEqualTo("Hi asa");
        assertThat(hello.sayThankYou("asa")).isEqualTo("Thank you asa");

        Hello proxiedHello = new HelloUppercase(new HelloTarget());
        assertThat(proxiedHello.sayHello("asa")).isEqualTo("HELLO ASA");
        assertThat(proxiedHello.sayHi("asa")).isEqualTo("HI ASA");
        assertThat(proxiedHello.sayThankYou("asa")).isEqualTo("THANK YOU ASA");
    }
}
