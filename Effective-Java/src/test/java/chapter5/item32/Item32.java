package chapter5.item32;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static chapter5.item32.Dangerous.dangerous;
import static chapter5.item32.FlattenWithVarargs.flatten;
import static chapter5.item32.FlattenWithList.flatten;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("아이템 32. 제네릭과 가변인수를 함께 쓸 때는 신중하라")
public class Item32 {

    @Test
    @DisplayName("제네릭과 varargs를 혼용하면 타입 안전성이 깨진다!")
    void item32_test_1() {
        assertThrows(ClassCastException.class, () -> {
            dangerous(List.of("There be dragons!"));
        });
    }

    @Test
    @DisplayName("자신의 제네릭 매개변수 배열의 참조를 노출한다. - 안전하지 않다!")
    void item32_test_2() {
        assertThrows(ClassCastException.class, () -> {
            String[] attributes = PicTwo.pickTwo("좋은", "빠른", "저렴한");
            System.out.println(Arrays.toString(attributes));
        });
    }

    @Test
    @DisplayName("제네릭 varargs 매개변수를 안전하게 사용하는 메서드")
    void item32_test_3() {
        List<Integer> flatList = flatten(
                List.of(1, 2), List.of(3, 4, 5), List.of(6,7));
        assertThat(flatList).containsExactly(1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    @DisplayName("제네릭 varargs 매개변수를 List로 대체한 예 - 타입 안전하다.")
    void item32_test_4() {
        List<Integer> flatList = flatten(List.of(
                List.of(1, 2), List.of(3, 4, 5), List.of(6,7)));
        assertThat(flatList).containsExactly(1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    @DisplayName("SafePicTwo")
    void item32_test_5() {
        // 배열 없이 제네릭만 사용하므로 타입 안전
    }
}
