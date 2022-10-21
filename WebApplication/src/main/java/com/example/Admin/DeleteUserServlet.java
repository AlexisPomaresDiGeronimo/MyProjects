package com.example.Admin;

import com.example.Data.CreateConnection;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "DeleteUserServlet", value = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection con = CreateConnection.newConnection();
            String DeleteUsername = request.getParameter("DeleteUsername");
            Statement createSt =con.createStatement();

            createSt.executeUpdate("DELETE FROM accounts where Username='"+ DeleteUsername +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        getServletContext().getRequestDispatcher("/AdminServlet").forward(request, response);
    }
}
