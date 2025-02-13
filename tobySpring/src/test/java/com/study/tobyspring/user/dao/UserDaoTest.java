package com.study.tobyspring.user.dao;

import com.study.tobyspring.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
    UserDao dao = context.getBean("userDao", UserDao.class);

    @BeforeEach
    void setUp() throws SQLException {
        dao.resetTable();
    }

    @Test
    void test() throws SQLException {
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
