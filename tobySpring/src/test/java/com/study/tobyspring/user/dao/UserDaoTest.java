package com.study.tobyspring.user.dao;

import com.study.tobyspring.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DaoFactory.class})
public class UserDaoTest {

    @Autowired
    private ApplicationContext context;

    private UserDao dao;
    private User user;

    @BeforeEach
    void setUp() throws SQLException {
        this.dao = context.getBean("userDao", UserDao.class);
        this.user = new User("baby", "아사", "monster");
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);
    }

    @Test
    void addAndGet() throws SQLException {
        dao.add(user);
        assertThat(dao.getCount()).isEqualTo(1);

        User userGet1 = dao.get(user.getId());
        assertThat(userGet1.getName()).isEqualTo(user.getName());
        assertThat(userGet1.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    void getUserFailure() {
        assertThrows(EmptyResultDataAccessException.class, () -> dao.get("unknown_id"));
    }
}
