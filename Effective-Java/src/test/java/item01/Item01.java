package item01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Item01 {

    @Test
    @DisplayName("장점1 : 이름을 가질수 있다")
    void item01_test_1() {
        Foo foo = new Foo("생성자");
        assertThat(foo.name).isEqualTo("생성자");

        Foo foo1 = Foo.withName("정적 팩터리 메서드");
        assertThat(foo1.name).isEqualTo("정적 팩터리 메서드");

        Foo foo2 = Foo.withAddress("시그니처가 같은 생성자");
        assertThat(foo2.name).isEqualTo("시그니처가 같은 생성자");
    }

    @Test
    @DisplayName("장점2: 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다.")
    void item01_test_2() {
        Foo foo = Foo.getFoo();
        Foo foo1 = Foo.getFoo();
        Foo foo2 = new Foo();
        assertThat(foo).isEqualTo(foo1);
        assertThat(foo1).isNotEqualTo(foo2);
    }

    @Test
    @DisplayName("장점3: 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.")
    void item01_test_3() {
        FooInterface.getFoo();
    }

    @Test
    @DisplayName("장점4: 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.")
    void item01_test_4() {
        Foo foo = Foo.getFoo(true);
        assertThat(foo).isInstanceOf(Foo.class);
    }

    @Test
    @DisplayName("장점5: 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.")
    void item01_test_5() {

    }
}
