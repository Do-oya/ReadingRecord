package com.study.tobyspring.user.service;

import com.study.tobyspring.user.dao.DaoFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoFactory.class)
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void bean() {

    }
}
