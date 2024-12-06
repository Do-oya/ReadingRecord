package chapter5.item29;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("아이템 29. 이왕이면 제네릭 타입으로 만들라")
public class Item29 {

    @Test
    @DisplayName("object 기반 스택 - 제네릭이 절실한 강력 후보!")
    void item29_test_1() {
        Stack_1 stack = new Stack_1();
        stack.push(10);
        assertThat(10).isEqualTo(stack.pop());
    }

    @Test
    @DisplayName("제네릭 스택으로 가는 첫 단계 - 컴파일되지 않는다.")
    void item29_test_2() {
        Stack_2 stack = new Stack_2();
        stack.push(10);
        assertThat(10).isEqualTo(stack.pop());
    }

    @Test
    @DisplayName("배열을 사용한 코드를 제네릭으로 만드는 방법 1")
    void item29_test_3() {
        // package chapter5.item29.Stack_2 @SuppressWarnings 태그 참고
    }

    @Test
    @DisplayName("배열을 사용한 코드를 제네릭으로 만드는 방법 2")
    void item29_test_4() {
        // package chapter5.item29.Stack_2 @SuppressWarnings 태그 참고
    }

    @Test
    @DisplayName("제네릭 Stack을 사용하는 맛보기 프로그램")
    void item29_test_5() {
        String[] args = {"a", "b", "c"};
        Stack<String> stack = new Stack<>();
        for (String arg : args)
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}
