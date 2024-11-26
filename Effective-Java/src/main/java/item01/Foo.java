package item01;

public class Foo {

    String name;

    public Foo() {
    }

    public Foo(String name) {
        this.name = name;
    }

    public static Foo withName(String name) {
        return new Foo(name);
    }

    public static Foo withAddress(String address) {
        return new Foo(address);
    }

    private static final Foo GOOD_NIGHT = new Foo();

    public static Foo getFoo() {
        return GOOD_NIGHT;
    }

    public static Foo getFoo(boolean flag) {
        return flag ? new Foo() : new BarFoo();
    }

    static class BarFoo extends Foo {
    }
}
