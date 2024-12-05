package chapter4.item20;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

@DisplayName("아이템 20. 추상 클래스보다는 인터페이스를 우선하라")
public class Item20 {
    @Test
    @DisplayName("골격 구현을 사용해 완성한 구체 클래스")
    void item20_test_1() {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++)
            a[i] = i;

        List<Integer> list = IntArrays.intArrayList(a);
        Collections.shuffle(list);
    }

    @Test
    @DisplayName("골격 구현 클래스")
    void item20_test_2() {
    }
}
