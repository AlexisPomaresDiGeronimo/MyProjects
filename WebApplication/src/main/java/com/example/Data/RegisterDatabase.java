package com.example.Data;

import java.sql.*;

public class RegisterDatabase {
    public static String insertAccount(String username, String Email, String password, String confirmPass){
        String error = "false";
        String message = "Error";
        String CheckUser = "null";
        String CheckEmail = "null";
        String CheckPass = "null";
        String CheckConfPass = "null";
        try {
            //Connection to Database
            Connection con = CreateConnection.newConnection();
            //Select from Database
            Statement checkUsernameSt = con.createStatement();
            ResultSet rs = checkUsernameSt.executeQuery("Select * FROM accounts where Username='" + username + "'");
            while (rs.next()) {
                CheckUser = rs.getString("Username");
                CheckEmail = rs.getString("Email");
                CheckPass = rs.getString("Password");
                CheckConfPass = rs.getString("ConfirmPassword");
            }
            //Check point
            if (CheckUser.equals(username) && CheckEmail.equals(Email) && CheckPass.equals(password)) {
                error = "AccountExist";
            } else if (username.equals(CheckUser)) {
                error = "usernameExist";
            } else {
                Statement createSt = con.createStatement();
                createSt.executeUpdate("insert into accounts (Username, Email, Password, ConfirmPassword) " +
                        "VALUES ('" + username + "','" + Email + "','" + password + "','" + confirmPass + "')");
                error = "Account Created Succesfully";
            }
            //catch sql errors
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //display errors
        switch (error) {
            case "AccountExist":
                message = "This Account already exist!";
                break;
            case "usernameExist":
                message = "This Username already exist!";
                break;
            case "Account Created Succesfully":
                message = "Account was created!";
                break;
        }
        return message;
    }
}