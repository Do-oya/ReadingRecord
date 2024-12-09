package chapter7.item42;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Comparator.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("아이템 42. 익명 클래스보다는 람다를 사용하라")
public class Item42 {

    private String[] text;
    private List<String> words;
    double x;
    double y;

    @BeforeEach
    void setUp() {
        text = new String[]{"apple", "banana", "Mango"};
        words = Arrays.asList(text);
        x = 3.0;
        y = 4.0;
    }

    @Test
    @DisplayName("익명 클래스의 인스턴스를 함수 객체로 사용 - 낡은 기법이다!")
    void item42_test_1() {
        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        assertThat(words).containsExactly("apple", "Mango", "banana");
    }

    @Test
    @DisplayName("람다식을 함수 객체로 사용 - 익명 클래스 대체")
    void item42_test_2() {
        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        assertThat(words).containsExactly("apple", "Mango", "banana");
    }

    @Test
    @DisplayName("람다 자리에 비교자 생성 메서드를 사용")
    void item42_test_3() {
        Collections.sort(words, comparingInt(String::length));
    }

    @Test
    @DisplayName("sort 메서드 사용")
    void item42_test_4() {
        words.sort(comparing(String::length));
    }

    @Test
    @DisplayName("상수별 클래스 몸체와 데이터를 사용한 열거 타입")
    void item42_test_5() {
        for (Operation_1 op : Operation_1.values())
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }

    @Test
    @DisplayName("함수 객체(람다)를 인스턴스 필드에 저장해 상수별 동작을 구현한 열거 타입")
    void item42_test_6() {
        for (Operation_1 op : Operation_1.values())
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }
}
