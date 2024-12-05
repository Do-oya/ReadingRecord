package chapter4.item23;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("아이템 23. 태그 달린 클래스보다는 클래스 계층구조를 활용하라")
public class Item23 {

    @Test
    @DisplayName("태그 달린 클래스 - 클래스 계층구조보다 훨씬 나쁘다!")
    void item23_test_1() {
        /* package chapter4.item23.Figure_1
        * 태그 달린 클래스는 장황하고, 오류를 내기 쉽고, 비효율적이다.
        * 태그 달린 클래스는 계층구조를 어설프게 흉내낸 아류일 뿐이다.
        * */
    }

    @Test
    @DisplayName("태그 달린 클래스를 클래스 계층구조로 변환")
    void item23_test_2() {
        /* package chapter4.item23.Figure_2
        *  package chapter4.item23.Circle
        *  package chapter4.item23.Rectangle
        *  package chapter4.item23.Square
        * */
    }
}
