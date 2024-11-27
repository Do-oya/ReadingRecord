package item03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("private 생성자나 열거 타입으로 싱글턴임을 보증하라")
public class Item03 {

    @Test
    @DisplayName("public static final 필드 방식의 싱글턴")
    void item03_test_1() {
        Elvis_1 elvis_1 = Elvis_1.INSTANCE;
        Elvis_1 elvis_2 = Elvis_1.INSTANCE;
        verifySingletonInstance(elvis_1, elvis_2);
    }

    @Test
    @DisplayName("정적 팩터리 방식의 싱글턴")
    void item03_test_2() {
        Elvis_2 elvis_1 = Elvis_2.getInstance();
        Elvis_2 elvis_2 = Elvis_2.getInstance();
        verifySingletonInstance(elvis_1, elvis_2);
    }

    @Test
    @DisplayName("열거 타입 방식의 싱글턴 - 바림직한 방법")
    void item03_test_3() {
        Elvis_3 elvis_1 = Elvis_3.INSTANCE;
        Elvis_3 elvis_2 = Elvis_3.INSTANCE;
        verifySingletonInstance(elvis_1, elvis_2);
    }

    private static <T> void verifySingletonInstance(T instance1, T instance2) {
        assertThat(instance1).isSameAs(instance2);
    }
}
