package chapter5.Item30;

import chapter5.item30.GenericSingletonFactory;
import chapter5.item30.RecursiveTypeBound;
import chapter5.item30.Union_1;
import chapter5.item30.Union_2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.UnaryOperator;

import static chapter5.item30.RecursiveTypeBound.max;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("아이템 30. 이왕이면 제니릭 메서드로 만들라")
public class Item30 {

    @Test
    @DisplayName("로 타입 사용 - 수용 불가!")
    void item30_test_1() {
        Union_1 union = new Union_1();
    }

    @Test
    @DisplayName("제네릭 메서드")
    void item30_test_2() {
        Set<String> guys = Set.of("톰", "딕", "해리");
        Set<String> stooges = Set.of("래리", "모에", "컬리");
        Set<String> aflCio = Union_2.union(guys, stooges);
        System.out.println(aflCio);
    }

    @Test
    @DisplayName("제네릭 싱글턴 팩터리 패턴")
    void item30_test_3() {
        String[] strings = {"삼베", "대마", "나일론"};
        UnaryOperator<String> sameString = GenericSingletonFactory.identityFunction();
        for (String s : strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = {1, 2.0, 3L};
        UnaryOperator<Number> sameNumber = GenericSingletonFactory.identityFunction();
        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
    }

    @Test
    @DisplayName("컬렉션에서 최댓값을 반환한다 - 재귀적 타입 한정 사용")
    void item30_test_4() {
        String[] strings = {};
        List<String> argList = Arrays.asList(strings);
        assertThrows(IllegalArgumentException.class, () -> {
            RecursiveTypeBound.max(argList);
        });
    }
}
