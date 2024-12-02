package chapter2.item09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class TopLine {
    static String firstLineOfString_1(String path) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    static String firstLineOfString_2(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new StringReader(path))) {
            return br.readLine();
        }
    }
}
