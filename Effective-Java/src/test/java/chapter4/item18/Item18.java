package chapter4.item18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("아이템 18. 상속보다는 컴포지션을 사용하라")
public class Item18 {

    @Test
    @DisplayName("잘못된 예 - 상속을 잘못 사용했다!")
    void item18_test_1() {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("틱", "탕탕", "펑"));
        assertThat(s.getAddCount()).isNotEqualTo(3);
    }

    @Test
    @DisplayName("래퍼 클래스 - 상속 대신 컴포지션을 사용했다.")
    void item18_test_2() {
        InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());
        s.addAll(List.of("틱", "탕탕", "펑"));
        assertThat(s.getAddCount()).isEqualTo(3);
    }
}
