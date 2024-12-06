package chapter5.item30;

import java.util.HashSet;
import java.util.Set;

public class Union_1 {
    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }
}
