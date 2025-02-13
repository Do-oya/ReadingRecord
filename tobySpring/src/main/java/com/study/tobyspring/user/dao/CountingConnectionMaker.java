package com.study.tobyspring.user.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;

@AllArgsConstructor
public class CountingConnectionMaker implements ConnectionMaker {

    @Getter
    int counter = 0;
    private ConnectionMaker realConnectionMaker;

    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        this.counter++;
        return realConnectionMaker.makeConnection();
    }
}
