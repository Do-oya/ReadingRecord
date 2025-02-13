package com.study.tobyspring.user.dao;

import com.study.tobyspring.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {

    private final UserDao dao = new DaoFactory().userDao();

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        dao.resetTable();
    }

    @Test
    void test() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        User user1 = dao.get(user.getId());
        assertThat(user1.getId()).isEqualTo("whiteship");
        assertThat(user1.getName()).isEqualTo("백기선");
        assertThat(user1.getPassword()).isEqualTo("married");
    }
}
