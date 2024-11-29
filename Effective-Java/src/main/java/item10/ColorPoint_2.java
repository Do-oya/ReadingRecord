package item10;

public class ColorPoint_2 extends Point_1 {
    private final Color color;

    public ColorPoint_2(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point_1))
            return false;
        if (!(o instanceof ColorPoint_2))
            return o.equals(this);
        return super.equals(o) && ((ColorPoint_2) o).color == color;
    }
}
