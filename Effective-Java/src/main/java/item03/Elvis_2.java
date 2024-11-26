package item03;

public class Elvis_2 {
    private static final Elvis_2 INSTANCE = new Elvis_2();
    private Elvis_2() {}
    public static Elvis_2 getInstance() {
        return INSTANCE;
    }
}
