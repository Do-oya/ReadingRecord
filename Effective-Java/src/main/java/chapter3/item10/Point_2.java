package chapter3.item10;

public class Point_2 {
    private final int x;
    private final int y;

    public Point_2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass())
            return false;
        Point_2 p = (Point_2) o;
        return p.x == x && p.y == y;
    }
}
