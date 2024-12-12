package chapter7.item46;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@DisplayName("아이템 46. 스트림에서는 부작용 없는 함수를 사용하라")
public class Item46 {

    private String input;

    @BeforeEach
    void setUp() {
        input = "apple banana apple cherry banana apple";
    }

    @Test
    @DisplayName("스트림 패러다임을 이해하지 못한 채 API만 사용했다 - 따라 하지 말 것!")
    void item46_test_1() {
        Map<String, Long> freq = new HashMap<>();
        try (Stream<String> words = new Scanner(input).tokens()) {
            words.forEach(word -> {
                freq.merge(word.toLowerCase(), 1L, Long::sum);
            });
        }
        extracted(freq);
    }

    @Test
    @DisplayName("스트림을 제대로 활용해 빈도표를 초기화한다.")
    void item46_test_2() {
        Map<String, Long> freq;
        try (Stream<String> words = new Scanner(input).tokens()) {
            freq = words.collect(groupingBy(String::toLowerCase, counting()));
        }
        extracted(freq);
    }

    private static void extracted(Map<String, Long> freq) {
        assert freq.get("apple") == 3L;
        assert freq.get("banana") == 2L;
        assert freq.get("cherry") == 1L;
    }
}
