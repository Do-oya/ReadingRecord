package chapter3.item11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("아이템 11. equals를 재정의하려거든 hashCode도 재정의하라")
public class Item11 {

    @Test
    @DisplayName("전형적인 hashCode 메서드")
    void item11_test_1() {
        Map<PhoneNumber_1, String> m = new HashMap<>();
        m.put(new PhoneNumber_1(707, 867, 5309), "두야");
        assertThat("두야").isEqualTo(m.get(new PhoneNumber_1(707, 867, 5309)));
    }

    @Test
    @DisplayName("한 줄짜리 hasCode 메서드 - 성능이 살짝 아쉽다")
    void item11_test_2() {
        Map<PhoneNumber_2, String> m = new HashMap<>();
        m.put(new PhoneNumber_2(707, 867, 5309), "두야");
        assertThat("두야").isEqualTo(m.get(new PhoneNumber_2(707, 867, 5309)));
    }

    @Test
    @DisplayName("해시코드를 지연 초기화하는 hashCode 메서드 - 스레드 안정성까지 고려해야 한다.")
    void item11_test_3() {
        Map<PhoneNumber_3, String> m = new HashMap<>();
        m.put(new PhoneNumber_3(707, 867, 5309), "두야");
        assertThat("두야").isEqualTo(m.get(new PhoneNumber_3(707, 867, 5309)));
    }
}
