package com.study.tobyspring.user.dao;

import com.study.tobyspring.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoConnectionCountingTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
    UserDao dao = context.getBean(UserDao.class);

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

        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("ConnectionMaker: " + ccm.getCounter());
    }
}
