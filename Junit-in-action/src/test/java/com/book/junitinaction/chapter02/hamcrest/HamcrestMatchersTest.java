package com.book.junitinaction.chapter02.hamcrest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;


public class HamcrestMatchersTest {

    private static String FIRST_NAME = "John";
    private static String LAST_NAME = "Smith";
    private static Customer customer = new Customer(FIRST_NAME, LAST_NAME);

    @Test
    @DisplayName("Hamcrest is, anyOf, allOf 매처를 사용한 테스트")
    void testHamcrestIs() {
        int price1 = 1, price2 = 2, price3 = 3;

        assertThat(1, is(price1));
        assertThat(1, anyOf(is(price2), is(price3)));
        assertThat(1, allOf(is(price1), is(price2)));
    }

    @Test
    @DisplayName("nullValue 매처를 사용한 테스트")
    void testNull() {
        assertThat(null, nullValue());
    }

    @Test
    @DisplayName("notNullValue 매처를 사용한 테스트")
    void testNotNull() {
        assertThat(customer, notNullValue());
    }

    @Test
    @DisplayName("hasProperty 매처를 사용한 테스트")
    void checkCorrectCustomerProperties() {
        assertThat(customer, allOf(
                hasProperty("firstName", is(FIRST_NAME)),
                hasProperty("lastName", is(LAST_NAME))
        ));
    }
}
