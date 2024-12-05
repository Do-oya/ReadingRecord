package chapter4.item22;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("아이템 22. 인터페이스는 타입을 정의하는 용도로만 사용하라")
public class Item22 {

    @Test
    @DisplayName("상수 인터페이스 안티패턴 - 사용금지!")
    void item22_test_1() {
        // package chapter4.item22.PhysicalConstants_1
    }

    @Test
    @DisplayName("상수 유틸리티 클래스")
    void item22_test_2() {
        // package chapter4.item22.PhysicalConstants_2
    }

    @Test
    @DisplayName("정적 임포트를 사용해 상수 이름만으로 사용하기")
    void item22_test_3() {
        
    }
}
