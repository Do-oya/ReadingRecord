package com.study.tobyspring.user.dao;

import com.study.tobyspring.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.*;

@RequiredArgsConstructor
public class UserDao {

    private final JdbcContext jdbcContext;
    private final JdbcTemplate jdbcTemplate;

    public void add(final User user) throws SQLException {
        this.jdbcContext.workWithStatementStrategy(c -> {
            PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");

            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());

            return ps;
        });
    }

    public void deleteAll() throws SQLException {
        this.jdbcContext.workWithStatementStrategy(c -> c.prepareStatement("delete from users"));
    }

    public User get(final String id) throws SQLException {
        return this.jdbcContext.executeQuery(c -> {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setString(1, id);
            return ps;
        }, rs -> {
            if (!rs.next()) throw new EmptyResultDataAccessException(1);

            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        });
    }

    public int getCount() throws SQLException {
        return this.jdbcContext.executeQuery(c -> c.prepareStatement("SELECT COUNT(*) FROM users"), new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet rs) throws SQLException {
                rs.next();
                return rs.getInt(1);
            }
        });
    }
}
