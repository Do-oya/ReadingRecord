package chapter5.item28;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("아이템 28. 배열보다는 리스트를 사용하라")
public class Item28 {

    @Test
    @DisplayName("런타임에 실패한다.")
    void item28_test_1() {
        Object[] objectArray = new Long[1];
        assertThrows(ArrayStoreException.class, () -> objectArray[0] = "타입이 달라 넣을 수 없다.");
    }

    @Test
    @DisplayName("컴파일 되지 않는다!")
    void item28_test_2() {
        /*List<Object> ol = new ArrayList<Long>();
        ol.add("타입이 달라 넣을 수 없다.");*/
    }

    @Test
    @DisplayName("제네릭 배열 생성을 허용하지 않는 이유 - 컴파일 되지 않는다.")
    void item28_test_3() {
        /*List<String>[] StringLists = new List<String>[1];
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList;
        String s = stringLists[0].get(0);*/
    }

    @Test
    @DisplayName("Chooser - 제네릭을 시급히 적용해야 한다!")
    void item28_test_4() {
        // package chapter5.item28.Chooser_1
    }

    @Test
    @DisplayName("Chooser를 제네릭으로 만들기 위한 첫 시도 - 컴파일 되지 않는다.")
    void item28_test_5() {
        // package chapter5.item28.Chooser_2
    }

    @Test
    @DisplayName("리스트 기반 Chooser - 타입 안전성 확보!")
    void item28_test_6() {
        // package chapter5.item28.Chooser_3
    }
}
