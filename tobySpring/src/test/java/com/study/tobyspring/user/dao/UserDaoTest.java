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
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);
    }

    @Test
    void addAndGet() throws SQLException {
        User user1 = new User("baby1", "아사", "monster1");
        User user2 = new User("baby2", "아현", "monster2");
        User user3 = new User("baby3", "로라", "monster3");


        dao.add(user1);
        dao.add(user2);
        dao.add(user3);
        assertThat(dao.getCount()).isEqualTo(3);

        User userGet1 = dao.get(user1.getId());
        User userGet2 = dao.get(user2.getId());
        User userGet3 = dao.get(user3.getId());

        assertThat(userGet1.getName()).isEqualTo(user1.getName());
        assertThat(userGet1.getPassword()).isEqualTo(user1.getPassword());

        assertThat(userGet2.getName()).isEqualTo(user2.getName());
        assertThat(userGet2.getPassword()).isEqualTo(user2.getPassword());

        assertThat(userGet3.getName()).isEqualTo(user3.getName());
        assertThat(userGet3.getPassword()).isEqualTo(user3.getPassword());
    }
}
