/*
package com.study.tobyspring.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;

public class Calculator {
    public Integer calcSum(String filePath) {
        LineCallback sumCallback = (line, value) -> value + Integer.parseInt(line);
        return lineReadTemplate(filePath, sumCallback, 0);
    }

    public Integer calcMultiply(String filepath) {
        LineCallback multiplyCallback = (line, value) -> value * Integer.parseInt(line);
        return lineReadTemplate(filepath, multiplyCallback, 1);
    }

    public <T> T lineReadTemplate(String filePath, LineCallback<T> callback, T initVal) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filePath));
            T res = initVal;
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
*/
