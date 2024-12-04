package chapter4.item17;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("아이템 17. 변경 가능성을 최소화하라")
/*
* 1. 객체의 상태를 변경하는 메서드(변경자)를 제공하지 않는다.
* 2. 클래스를 확장할 수 없도록 한다.
* 3. 모든 필드를 final로 선언한다.
* 4. 모든 필드를 private으로 선언한다.
* 5. 자신 외에는 내부의 가변 컴포넌트에 접근할 수 없도록 한다.*/
public class Item17 {

    @Test
    @DisplayName("불변 복소수 클래스")
    void item17_test_1() {
        Complex complex = new Complex(1.0, 2.0);
        assertThat(complex.realPart()).isEqualTo(1.0);
        assertThat(complex.imaginaryPart()).isEqualTo(2.0);
    }

    @Test
    @DisplayName("생성자 대신 정적 팩터리를 사용한 불변 클래스")
    void item17_test_2() {
        Complex complex = Complex.valueOf(1.0, 2.0);
        assertThat(complex.realPart()).isEqualTo(1.0);
        assertThat(complex.imaginaryPart()).isEqualTo(2.0);
    }
}
