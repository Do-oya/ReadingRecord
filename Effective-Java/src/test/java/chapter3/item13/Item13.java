package chapter3.item13;

import chapter3.item13.PhoneNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("아이템 13. clone 재정의는 주의해서 진행하라")
public class Item13 {

    @Test
    @DisplayName("가변 상태를 참조하지 않는 클래스용 clone 메서드")
    void item13_test_1() {
        PhoneNumber pn = new PhoneNumber(707, 867, 5309);
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(pn, "클론");
        assertThat("클론").isEqualTo(m.get(pn));
    }

    @Test
    @DisplayName("가변 상태를 참조하는 클래스용 clone 메서드")
    void item13_test_2() {
    }
}
