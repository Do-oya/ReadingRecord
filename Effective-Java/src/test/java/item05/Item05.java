package item05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("아이템 5. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라")
public class Item05 {

    @Test
    @DisplayName("정적 유틸리티를 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.")
    void item05_test_1() {
        SpellChecker_1.isValid("hello");
    }

    @Test
    @DisplayName("싱글턴을 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.")
    void item05_test_2() {
        SpellChecker_2.INSTANCE.isValid("hello");
    }

    @Test
    @DisplayName("의존 객체 주입은 유연성과 테스트 용이성을 높여준다.")
    void item05_test_3() {
        SpellChecker_3.isValid("hello");
    }
}
