package com.book.junitinaction.chapter02.displayname;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("@DisplayName을 사용한 테스트")
public class DisplayNameTest {
    private SUT systemUnderTest = new SUT();

    @Test
    @DisplayName("hello 테스트 대상 시스템")
    void testHello() {
        assertEquals("Hello", systemUnderTest.hello());
    }

    @Test
    @DisplayName("😫")
    void testTalking() {
        assertEquals("How are you?", systemUnderTest.talk());
    }

    @Test
    void testBY() {
        assertEquals("Bye", systemUnderTest.bye());
    }
}
