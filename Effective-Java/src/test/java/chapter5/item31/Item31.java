package chapter5.item31;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

@DisplayName("아이템 31. 한정적 와일드카드를 사용해 API 유연성을 높이라")
public class Item31 {

    @Test
    @DisplayName("와일드카드 타입을 사용하지 않은 pushAll 메서드 - 결함이 있다!")
    void item31_test_1() {
        Stack_1<Number> numberStack = new Stack_1<>();
        Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
//        numberStack.pushAll(integers);
    }

    @Test
    @DisplayName("생산자(producer) 매개변수에 와일드카드 타입 적용")
    void item31_test_2() {
        Stack_2<Number> numberStack = new Stack_2<>();
        Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
        numberStack.pushAll(integers);
    }

    @Test
    @DisplayName("와일드카드 타입을 사용하지 않은 popAll 메서드 - 결함이 있다!")
    void item31_test_3() {
        Stack_3<Number> numberStack = new Stack_3<>();
        Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
        numberStack.pushAll(integers);
        Collection<Object> objects = new ArrayList<>();
//        numberStack.popALl(objects);
    }

    @Test
    @DisplayName("소비자(consumer) 매개변수에 와일드카드 타입 적용")
    void item31_test_4() {
        Stack_4<Number> numberStack = new Stack_4<>();
        Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
        numberStack.pushAll(integers);
        Collection<Object> objects = new ArrayList<>();
        numberStack.popALl(objects);
    }

    @Test
    @DisplayName("생성자 매개변수에 와일드카드 타입 적용")
    void item31_test_5() {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
        Chooser<Number> chooser = new Chooser<>(intList);
        for (int i = 0; i < 10; i++) {
            Number choice = chooser.choose();
            System.out.println(choice);
        }
    }
}
