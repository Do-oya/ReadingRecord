package com.study.tobyspring.user.service;

import com.study.tobyspring.user.dao.DaoFactory;
import com.study.tobyspring.user.dao.UserDao;
import com.study.tobyspring.user.domain.Level;
import com.study.tobyspring.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoFactory.class)
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    private UserDao dao;
    private User user;

    @BeforeEach
    void setUp() {
        this.user = new User("baby", "아사", "monster", Level.GOLD, 1, 0);
        dao.deleteAll();
    }

    @Test
    void bean() {
        assertThat(this.userService).isNotNull();
    }

    @Test
    void upgradeLevels() {
        dao.add(user);

        userService.upgradeLevels();

        assertThat(user.getLevel()).isEqualTo(Level.GOLD);
    }
}
