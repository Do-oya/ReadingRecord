package com.study.tobyspring.user.dao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

@RequiredArgsConstructor
public class CountingConnectionMaker implements ConnectionMaker {

    @Getter
    int counter = 0;

    private final ConnectionMaker realConnectionMaker;


    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        this.counter++;
        return realConnectionMaker.makeConnection();
    }
}
