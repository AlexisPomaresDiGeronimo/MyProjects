package com.example.Admin;

import com.example.Data.CreateConnection;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CheckUser = "null";
        String CheckEmail = "null";
        String CheckPass = "null";
        ArrayList<ArrayList<String>> usersList = new ArrayList<>();
        try{
        //Connection to Database
        Connection con = CreateConnection.newConnection();
        //Select from Database
        Statement checkUsernameSt = con.createStatement();
        ResultSet rs = checkUsernameSt.executeQuery("Select * FROM accounts");
        while (rs.next()) {
            ArrayList<String> users= new ArrayList<>();
            CheckUser = rs.getString("Username");
            CheckEmail = rs.getString("Email");
            CheckPass = rs.getString("Password");
            users.add(CheckUser);
            users.add(CheckEmail);
            users.add(CheckPass);
            usersList.add(users);
            request.setAttribute("usersList", usersList);
        }
            getServletContext().getRequestDispatcher("/AdminPage.jsp").forward(request, response);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/AdminPage.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

