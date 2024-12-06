package chapter5.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack_2<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack_2() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
//        elements = E[DEFAULT_CAPACITY]; 컴파일 되지 않음.
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        @SuppressWarnings("unchecked") E result = (E) elements[--size];

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
