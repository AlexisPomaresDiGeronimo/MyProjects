package com.example.Data;

import java.sql.*;


public class CreateConnection {
    public static Connection newConnection() throws ClassNotFoundException, SQLException {
        String host = "jdbc:mysql://localhost:3306/javawebapp";
        String uname = "root";
        String pass = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(host, uname, pass);

        return connection;
    }
}
