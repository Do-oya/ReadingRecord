package com.study.tobyspring.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        return new UserDao(jdbcContextWithStatementStrategy());
    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3306/springbook");
        dataSource.setUsername("root");
        dataSource.setPassword("1441");

        return dataSource;
    }

    @Bean
    public JdbcContext jdbcContextWithStatementStrategy() {
        return new JdbcContext(dataSource());
    }
}
