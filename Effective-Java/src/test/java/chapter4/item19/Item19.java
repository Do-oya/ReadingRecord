package chapter4.item19;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("아이템 19. 상속을 고려해 설계하고 문서화하라. 그러지 않았다면 상속을 금지하라")
/*
* 상속용 클래스는 재정의할 수 있는 메서드들을 내부적으로 어떻게 이용하는지(자기사용) 문서로 남겨야 한다.
* */
public class Item19 {

    @Test
    @DisplayName("잘못된 예 - 생성자가 재정의 가능 메서드를 호출한다.")
    void item19_test_1() {
        Super s = new Super();
        s.overrideMe();
    }

    @Test
    @DisplayName("하위 클래스의 코드로, overrideMe 메서드를 재정의")
    void item19_test_2() {
        Sub s = new Sub();
        s.overrideMe();
    }
}
