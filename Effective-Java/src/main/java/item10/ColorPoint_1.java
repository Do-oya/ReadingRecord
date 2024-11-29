package item10;

public class ColorPoint_1 extends Point_1 {
    private final Color color;

    public ColorPoint_1(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint_1))
            return false;
        return super.equals(o) && ((ColorPoint_1) o).color == this.color;
    }
}
