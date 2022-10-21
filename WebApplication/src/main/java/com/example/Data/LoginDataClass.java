package com.example.Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDataClass {
    public static String checkIfAccountExist(String lgnUsername, String lgnPass){
        String CheckUsername="null";
        String CheckPassword="null";
        String message="null";
        try{
            //Connection to Database
            Connection con = CreateConnection.newConnection();
            //Select from Database
            Statement checkUsernameSt= con.createStatement();
            ResultSet rs= checkUsernameSt.executeQuery("Select * FROM accounts where Username='"+lgnUsername+"'");
            while(rs.next()){
                CheckUsername= rs.getString("Username");
                CheckPassword= rs.getString("Password");
            }
            //Check point
            if(CheckUsername.equals(lgnUsername) && CheckPassword.equals(lgnPass)) {
                message = "You are logged in!!";
            }else if(CheckUsername.equals("") || CheckPassword.equals("")){
                message="Complete all the fields";
            }else if(!CheckUsername.equals(lgnUsername) || !CheckPassword.equals(lgnPass)){
                message="Username or Password not correct!";
            }
            else{
                message="This account not exist!!";
            }
        //catch sql errors
        }catch(SQLException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return message;

    }
}
