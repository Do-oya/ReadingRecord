package com.study.tobyspring.user.dao;

import com.study.tobyspring.user.domain.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {

    @Test
    void add_test() throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);
    }

    @Test
    void get_test() throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();

        User user = dao.get("whiteship");
        assertThat(user.getId()).isEqualTo("whiteship");
        assertThat(user.getName()).isEqualTo("백기선");
        assertThat(user.getPassword()).isEqualTo("married");
    }
}
