package com.study.tobyspring.user.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
public class JdbcContext {
    private final DataSource dataSource;

    public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = dataSource.getConnection();
            ps = stmt.makePreparedStatement(c);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public <T> T executeQuery(StatementStrategy stmt, ResultSetExtractor<T> extractor) throws SQLException {
        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = stmt.makePreparedStatement(c);
             ResultSet rs = ps.executeQuery()) {

            return extractor.extractData(rs);
        }
    }
}
