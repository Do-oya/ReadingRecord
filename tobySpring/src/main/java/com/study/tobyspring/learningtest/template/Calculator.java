package com.study.tobyspring.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
    public Integer calcSum(String filePath) throws IOException {
        LineCallback sumCallback = (line, value) -> value + Integer.parseInt(line);
        return lineReadTemplate(filePath, sumCallback, 0);
    }

    public Integer calcMultiply(String filepath) throws IOException {
        LineCallback multiplyCallback = (line, value) -> value * Integer.parseInt(line);
        return lineReadTemplate(filepath, multiplyCallback, 1);
    }

    public Integer lineReadTemplate(String filePath, LineCallback callback, int initVal) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            Integer res = initVal;
            String line;
            while ((line = br.readLine()) != null) {
                res = callback.doSomethingWithLine(line, res);
            }
            return res;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }
        return lineReadTemplate(filePath, callback, initVal);
    }
}
