package com.study.tobyspring.learningtest.template;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcSumTest {
    Calculator calculator;
    String numFilePath;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
        this.numFilePath = getClass().getResource("/numbers.txt").getPath();
    }

    @Test
    void sumOfNumbers() throws IOException {
        assertThat(calculator.calcSum(this.numFilePath)).isEqualTo(10);
    }

    @Test
    void multiplyNumbers() throws IOException {
        assertThat(calculator.calcMultiply(this.numFilePath)).isEqualTo(24);
    }
}
