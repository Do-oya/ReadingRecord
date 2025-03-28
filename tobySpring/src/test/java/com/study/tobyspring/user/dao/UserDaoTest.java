package com.study.tobyspring.user.dao;

import com.study.tobyspring.user.domain.Level;
import com.study.tobyspring.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DaoFactory.class})
public class UserDaoTest {

    @Autowired
    UserDao dao;

    private User user;

    @BeforeEach
    void setUp() {
        this.user = new User("baby", "아사", "monster", Level.BASIC, 1, 0);
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);
    }

    @Test
    void addAndGet() {
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

    @Test
    void update() {
        dao.add(user);

        user.setName("사나");
        user.setPassword("twice");
        user.setLevel(Level.GOLD);
        user.setLogin(1000);
        user.setRecommend(999);
        dao.update(user);

        User userUpdate = dao.get(user.getId());
        assertThat(userUpdate.getName()).isEqualTo(user.getName());
    }
}
