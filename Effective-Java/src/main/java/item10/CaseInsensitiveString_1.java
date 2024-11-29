package item10;

import java.util.Objects;

public final class CaseInsensitiveString_1 {
    private final String s;

    public CaseInsensitiveString_1(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString_1)
            return s.equalsIgnoreCase(((CaseInsensitiveString_1) o).s);
        if (o instanceof String)
            return s.equalsIgnoreCase((String) o);
        return false;
    }
}
