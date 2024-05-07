package com.company.dao.inter;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {
    
    @SneakyThrows
    public Connection connect() {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "admin123";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}
