package com.study.tobyspring.user.dao;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

@Import(DaoFactory.class)
class DaoFactoryTest {

    @Test
    void test() {
        DaoFactory factory = new DaoFactory();
        UserDao dao1 = factory.userDao();
        UserDao dao2 = factory.userDao();

        System.out.println(dao1);
        System.out.println(dao2);

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactoryTest.class);

        UserDao dao3 = context.getBean(UserDao.class);
        UserDao dao4 = context.getBean(UserDao.class);

        System.out.println(dao3);
        System.out.println(dao4);
    }
}