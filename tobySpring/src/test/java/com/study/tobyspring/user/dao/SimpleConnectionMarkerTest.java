package com.study.tobyspring.user.dao;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class SimpleConnectionMarkerTest {

    @Test
    void test() throws SQLException, ClassNotFoundException {
        SimpleConnectionMarker scm = new SimpleConnectionMarker();
        scm.makeNewConnection();
    }
}
