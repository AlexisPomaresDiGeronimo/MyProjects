package com.example.Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EditRegisterDatabase {
    public static String insertEditAccount(String username ,String newusername, String Email, String password){
            String error = "false";
            String message = "Error";
            String CheckUser = "null";
            String CheckEmail = "null";
            String CheckPass = "null";
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
                }
                //Check point
                if (CheckUser.equals(newusername) && CheckEmail.equals(Email) && CheckPass.equals(password)) {
                    error = "AccountExist";
                } else if(newusername.equals(null) || newusername.equals("")){
                    Statement createSt = con.createStatement();
                    createSt.executeUpdate("UPDATE accounts SET Username = '"+ username +"', Email = '"+ Email +"', Password = '"+ password +"', ConfirmPassword = '"+ password +"'" +
                            "WHERE Username= '"+ CheckUser +"'");
                }
                else {
                    Statement createSt = con.createStatement();
                    createSt.executeUpdate("UPDATE accounts SET Username = '"+ newusername +"', Email = '"+ Email +"', Password = '"+ password +"', ConfirmPassword = '"+ password +"'" +
                            "WHERE Username= '"+ CheckUser +"'");
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
                case "Account Created Succesfully":
                    message = "Account was created!";
                    break;
            }
            return message;
        }
}
