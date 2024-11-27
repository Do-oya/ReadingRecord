package item06;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("아이템 6. 불필요한 객체 생성을 피하라")
public class Item06 {

    @Test
    @DisplayName("성능을 훨씬 끌어올릴수 있다!")
    void item06_test_1() {
        String validRoman = "XIV";
        String invalidRoman = "ABC";

        assertTrue(RomanNumerals.isRomanNumeralSlow(validRoman));
        assertFalse(RomanNumerals.isRomanNumeralSlow(invalidRoman));
    }

    @Test
    @DisplayName("값비싼 객체를 재사용해 성능을 개선한다.")
    void item06_test_2() {
        String validRoman = "XIV";
        String invalidRoman = "ABC";

        assertTrue(RomanNumerals.isRomanNumeralFast(validRoman));
        assertFalse(RomanNumerals.isRomanNumeralFast(invalidRoman));
    }
}
