package chapter3.item10;

import java.util.Objects;

public final class CaseInsensitiveString_2 {
    private final String s;

    public CaseInsensitiveString_2(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString_2 && ((CaseInsensitiveString_2) o).s.equalsIgnoreCase(s);
    }
}
