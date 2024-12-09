package chapter6.item36;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

@DisplayName("아이템 36. 비트 필드 대신 EnumSet을 사용하라")
public class Item36 {

    @Test
    @DisplayName("비트 필드 열거 상수 - 구닥다리 기법!")
    void item36_test_1() {
        // package chapter6.item36.Text_1 참고
    }

    @Test
    @DisplayName("EnumSet - 비트 필드를 대체하는 현대적 기법")
    void item36_test_2() {
        Text_2 text = new Text_2();
        text.applyStyles(EnumSet.of(Text_2.Style.BOLD, Text_2.Style.ITALIC));
    }
}
