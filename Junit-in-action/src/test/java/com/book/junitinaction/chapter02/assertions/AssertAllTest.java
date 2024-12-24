package com.book.junitinaction.chapter02.assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertAllTest {
    private SUT systemUnderTest = new SUT("테스트 대상 시스템");

    @Test
    @DisplayName("기본적으로 테스트 대상 시스템은 검증하지 않는다")
    void testSystemNotVerified() {
        assertAll("테스트 대상 시스템을 검증하지 않았는지 확인",
                () -> assertEquals("테스트 대상 시스템", systemUnderTest.getSystemName()),
                () -> assertFalse(systemUnderTest.isVerified()));
    }

    @Test
    @DisplayName("테스트 대상 시스템을 검증한다")
    void testSystemUnderVerification() {
        systemUnderTest.verify();

        assertAll("테스트 대상 시스템을 검증했는지 확인",
                () -> assertEquals("테스트 대상 시스템", systemUnderTest.getSystemName()),
                () -> assertTrue(systemUnderTest.isVerified()));
    }

    @Test
    @DisplayName("테스트 대상 시스템을 검증한다")
    void testSystemUnderVerification2() {
        systemUnderTest.verify();
        assertTrue(systemUnderTest.isVerified(),
                () -> "테스트 대상 시스템을 검증했는지 확인");
    }

    @Test
    @DisplayName("테스트 대상 시스템을 검증하지 않았다")
    void testSystemNotUnderVerification() {
        assertFalse(systemUnderTest.isVerified(),
                () -> "테스트 대상 시스템을 검증하지 않았는지 확인");
    }

    @Test
    @DisplayName("현재 테스트 대상 시스템은 작업이 없다")
    void testNoJob() {
        assertNull(systemUnderTest.getCurrentJob(),
                () -> "테스트 대상 시스템은 현재 작업이 없는지 확인");
    }
}
