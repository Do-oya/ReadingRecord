package chapter4.item20;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class IntArrays {
    static List<Integer> intArrayList(int[] a) {
        Objects.requireNonNull(a);

        return new AbstractList<>() {
            @Override
            public Integer get(int i) {
                return a[i];
            }

            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val;
                return oldVal;
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }
}
