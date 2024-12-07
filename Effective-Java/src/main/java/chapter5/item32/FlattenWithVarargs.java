package chapter5.item32;

import java.util.ArrayList;
import java.util.List;

public class FlattenWithVarargs {
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list: lists)
            result.addAll(list);
        return result;
    }
}
