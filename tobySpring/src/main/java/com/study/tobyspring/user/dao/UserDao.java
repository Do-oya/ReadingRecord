package com.study.tobyspring.user.dao;

import com.study.tobyspring.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@RequiredArgsConstructor
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public void add(final User user) {
        this.jdbcTemplate.update("insert into users (id, name, password) values (?, ?, ?)", user.getId(), user.getName(), user.getPassword());
    }

    public void deleteAll() {
        this.jdbcTemplate.update("delete from users");
    }

    public User get(final String id) {
        return this.jdbcTemplate.queryForObject("select * from users where id = ?", new Object[] {id},
                (rs, rowNum) -> {
                    User user = new User();
                    user.setId(rs.getString("id"));
                    user.setName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    return user;
                });
    }

    public int getCount() {
        return this.jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
    }
}
