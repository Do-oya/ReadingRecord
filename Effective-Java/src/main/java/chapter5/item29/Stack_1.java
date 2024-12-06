package chapter5.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack_1 {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;

    public Stack_1() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, size * 2 + 1);
    }
}
