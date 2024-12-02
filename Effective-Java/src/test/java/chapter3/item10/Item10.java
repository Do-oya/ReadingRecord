package chapter3.item10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("아이템 10. equals는 일반 규약을 지켜 재정의하라")
/*
* 1. == 연산자를 사용해 입력이 자기 자신의 참조인지 확인한다.
* 2. instanceof 연산자로 입력이 올바른 타입인지 확인한다.
* 3. 입력을 올바른 타입으로 형변환한다.
* 4. 입력 객체와 자기 자신의 대응되는 '핵심' 필드들이 모두 일치하는지 하나씩 검사한다.*/
public class Item10 {

    @Test
    @DisplayName("잘못된 코드 - 대칭성 위배!")
    void item10_test_1() {
        CaseInsensitiveString_1 cis_1 = new CaseInsensitiveString_1("Polish");
        String s = "polish";

        assertEquals(cis_1, s);
        assertNotEquals(s, cis_1);
    }

    @Test
    @DisplayName("대칭성 준수")
    void item10_test_2() {
        CaseInsensitiveString_2 cis_2 = new CaseInsensitiveString_2("Polish");
        CaseInsensitiveString_2 cis_3 = new CaseInsensitiveString_2("Polish");

        assertEquals(cis_2, cis_3);
    }

    @Test
    @DisplayName("잘못된 코드 - 대칭성 위배!")
    void item10_test_3() {
        Point_1 point = new Point_1(10, 10);
        ColorPoint_1 cp = new ColorPoint_1(10, 10, Color.RED);
        assertEquals(point, cp);
        assertNotEquals(cp, point);
    }

    @Test
    @DisplayName("잘못된 코드 - 추이성 위배!")
    void item10_test_4() {
        Point_1 point = new Point_1(10, 10);
        ColorPoint_2 cp_1 = new ColorPoint_2(10, 10, Color.RED);
        ColorPoint_2 cp_2 = new ColorPoint_2(10, 10, Color.BLUE);

        assertEquals(point, cp_1);
        assertEquals(cp_1, point);
        assertNotEquals(cp_1, cp_2);
    }

    @Test
    @DisplayName("전형적인 equals 메서드의 예")
    void item10_test_5() {
        PhoneNumber phoneNumber = new PhoneNumber(999, 999, 9999);
        PhoneNumber phoneNumber2 = new PhoneNumber(999, 999, 9999);

        assertEquals(phoneNumber, phoneNumber2);
        assertEquals(phoneNumber2, phoneNumber);
    }
}
