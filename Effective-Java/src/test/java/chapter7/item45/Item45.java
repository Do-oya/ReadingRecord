package chapter7.item45;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

@DisplayName("아이템 45. 스트림은 주의해서 사용하라")
public class Item45 {

    private List<String> dictionary;
    private int minGroupSize;

    @BeforeEach
    void setUp() {
        dictionary = Arrays.asList(
                "apple", "pleap", "pear", "reap", "leap", "pale", "banana", "ananab"
        );
        minGroupSize = 2;
    }

    @Test
    @DisplayName("문자열 배열로 아나그램 그룹 찾기")
    void item45_test_1() {
        Map<String, Set<String>> groups = new HashMap<>();

        for (String word : dictionary) {
            groups.computeIfAbsent(alphabetize(word),
                    (unused) -> new TreeSet<>()).add(word);
        }

        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize) {
                System.out.println(group.size() + ": " + group);
            }
        }
    }

    @Test
    @DisplayName("스트림을 적절히 활용하면 깔끔하고 명료해진다.")
    void item45_test_2() {
        /*dictionary.stream()
                .collect(groupingBy(this::alphabetize, TreeMap::new, TreeSet::new))
                .values().stream()
                .filter(group -> group.size() >= minGroupSize)
                .forEach(group -> System.out.println(group.size() + ": " + group));*/
    }

    private String alphabetize(String s) {
        char[] a = s.toLowerCase().toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
