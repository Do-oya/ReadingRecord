package com.book.junitinaction.chapter02.lifecycle;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SUTTest {
    private static ResourceForAllTests resourceForAllTests;
    private SUT systemUnderTest;


    // 전체 테스트가 실행되기 전에 한번 실행, @BeforeAll 애노테이션이 붙은 메서드는 테스트 클래스에 @TestInstance(Lifecycle.PER_CLASS) 애노테이션이 없다면 정적으로 선언해야 한다.
    @BeforeAll
    static void setUpClass() {
        resourceForAllTests = new ResourceForAllTests("테스트를 위한 리소스");
    }
    // 전체 테스트가 실행된 후 한 번 실행, @AfterAll 애노테이션이 붙은 메서드는 테스트 클래스에 @TestInstance(Lifecycle.PER_CLASS) 애노테이션이 없다면 정적으로 선언해야 한다.
    @AfterAll
    static void tearDownClass() {
        resourceForAllTests.close();
    }
    // 각 테스트가 실행되기 전에 실행, 예제에는 테스트 메서드가 두 개 있으므로 총 두 번 실행된다.
    @BeforeEach
    void setUp() {
        systemUnderTest = new SUT("테스트 대상 시스템");
    }
    // 각 테스트가 실행된 이후에 실행된다. 예제에는 테스트 메서드가 두 개 있으므로 총 두 번 실행된다.
    @AfterEach
    void tearDown() {
        systemUnderTest.close();
    }

    @Test
    void testRegularWork() {
        boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();
        assertTrue(canReceiveRegularWork);
    }

    @Test
    void testAdditionalWork() {
        boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();
        assertFalse(systemUnderTest.canReceiveAdditionalWork());
    }
}
