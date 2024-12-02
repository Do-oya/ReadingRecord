package chapter3.item14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

@DisplayName("아이템 14. Comparable을 구현할지 고려하라")
public class Item14 {

    @Test
    @DisplayName("객체 참조 필드가 하나뿐인 비교자")
    void item14_test_1() {
        String[] arg = new String[]{"Test"};
        Set<CaseInsensitiveString> s = new TreeSet<>();
        for (String test : arg)
            s.add(new CaseInsensitiveString(test));
        System.out.println(s);
    }

    @Test
    @DisplayName("기본 타입 필드가 여럿일 때의 비교자")
    void item14_test_2() {
    }
}
