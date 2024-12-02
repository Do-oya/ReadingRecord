package chapter3.item10;

public class Point_1 {
    private final int x;
    private final int y;

    public Point_1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point_1))
            return false;
        Point_1 p = (Point_1) o;
        return p.x == x && p.y == y;
    }
}
