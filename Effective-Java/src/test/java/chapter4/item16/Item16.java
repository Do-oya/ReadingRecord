package chapter4.item16;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("아이템 16. public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라")
public class Item16 {

    @Test
    @DisplayName("이처럼 퇴보한 클래스는 public이어서는 안 된다!")
    void item16_test_1() {
        // 캡슐화에 이점을 제공하지 못함
        Point_1 point = new Point_1();
    }

    @Test
    @DisplayName("접근자와 변경자(mutator) 메서드를 활용해 데이터를 캡슐화한다.")
    void item16_test_2() {
        Point_2 point = new Point_2();
    }

    @Test
    @DisplayName("불변 필드를 노출한 public 클래스 - 과연 좋은가?")
    void item16_test_3() {
        Time time = new Time(14, 15);
    }
}
