package com.study.tobyspring.user.dao;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementStrategyTest {

    @Test
    void test() {
        StatementStrategy statementStrategy = new StatementStrategy() {
            @Override
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                return null;
            }
        };
    }
}
