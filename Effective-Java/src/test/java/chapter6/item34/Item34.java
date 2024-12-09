package chapter6.item34;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("아이템 34. int 상수 대신 열거 타입을 사용하라")
public class Item34 {

    @Test
    @DisplayName("데이터와 메서드를 갖는 열거 타입")
    void item32_test_1() {
        String[] args = {"185"};
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("%site 무게는 %f이다.%n",
                    p, p.surfaceWeight(mass));
    }
}