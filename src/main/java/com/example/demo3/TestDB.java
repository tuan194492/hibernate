package com.example.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {
    private static final String url = "jdbc:postgresql://localhost:5432/quanlysinhvien";
    private static final String username = "postgres";
    private static final String password = "#Tuan267";

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return connection;
    }

}
