package chapter2.item07;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("아이템 7. 다 쓴 객체 참조를 해제하라")
public class Item07 {

    @Test
    @DisplayName("메모리 누수가 일어나는 위치는 어디인가?")
    void item07_testMemoryLeakInStack_1() {
        Stack_1 stack = new Stack_1();
        simulateMemoryUsage(stack, 1_000_000);
    }

    @Test
    @DisplayName("제대로 구현한 pop 메서드")
    void item07_testNoMemoryLeakInStack_2() {
        Stack_2 stack = new Stack_2();
        simulateMemoryUsage(stack, 1_000_000);
    }

    private void simulateMemoryUsage(Object stack, int iterations) {
        Runtime runtime = Runtime.getRuntime();
        List<Object> objects = new ArrayList<>();

        // 메모리 사용량 추적
        System.out.println("초기 메모리 상태:");
        printMemoryUsage(runtime);

        try {
            for (int i = 0; i < iterations; i++) {
                Object obj = new Object();
                if (stack instanceof Stack_1) {
                    ((Stack_1) stack).push(obj);
                    ((Stack_1) stack).pop();
                } else if (stack instanceof Stack_2) {
                    ((Stack_2) stack).push(obj);
                    ((Stack_2) stack).pop();
                }
                objects.add(obj); // 리스트에 객체를 보관하여 메모리 사용 증가 유도

                if (i % 100_000 == 0) {
                    System.out.println("Iteration: " + i);
                    printMemoryUsage(runtime);
                }
            }
        } catch (OutOfMemoryError e) {
            System.err.println("Out of Memory 발생!");
        }

        System.out.println("최종 메모리 상태:");
        printMemoryUsage(runtime);
    }

    private void printMemoryUsage(Runtime runtime) {
        long freeMemory = runtime.freeMemory();
        long totalMemory = runtime.totalMemory();
        long usedMemory = totalMemory - freeMemory;
        System.out.printf("Used Memory: %d KB\n", usedMemory / 1024);
    }
}