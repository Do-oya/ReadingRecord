package chapter4.item24;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("아이템 24. 멤버 클래스는 되도록 static으로 만들라")
public class Item24 {

    @Test
    @DisplayName("비정적 멤버 클래스의 흔한 쓰임 - 자신의 반복자 구현")
    void item24_test_1() {
        // 멤버 클래스에서 바깥 인스턴스에 접글할 일이 없다면 무조건 static을 붙여서 정적 멤버 클래스로 만들자.
    }
}
