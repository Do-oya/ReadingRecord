package chapter2.item04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.*;

@DisplayName("아이템 4. 인스턴스화를 막으려거든 private 생성자를 사용하라")
public class Item04 {

    @Test
    @DisplayName("인스턴스를 만들 수 없는 유틸리티 클래스")
    void item04_test_1() throws Exception {
        Constructor<UtilityClass> constructor = UtilityClass.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        assertThatThrownBy(constructor::newInstance)
                .isInstanceOf(InvocationTargetException.class)
                .hasCauseInstanceOf(AssertionError.class)
                .cause()
                .hasMessage("인스턴스화 방지");
    }
}
