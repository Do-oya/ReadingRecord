package com.study.tobyspring.user.dao;

import com.study.tobyspring.user.domain.User;

import java.sql.*;

public class UserDao {

    private SimpleConnectionMarker simpleConnectionMaker;

    public UserDao() {
        simpleConnectionMaker = new SimpleConnectionMarker();
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = simpleConnectionMaker.makeNewConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = simpleConnectionMaker.makeNewConnection();

        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public void resetTable() throws ClassNotFoundException, SQLException {
        Connection c = simpleConnectionMaker.makeNewConnection();
        Statement stmt = c.createStatement();

        stmt.execute("SET FOREIGN_KEY_CHECKS = 0");
        stmt.execute("TRUNCATE TABLE users");
        stmt.execute("SET FOREIGN_KEY_CHECKS = 1");

        stmt.close();
        c.close();
    }
}
