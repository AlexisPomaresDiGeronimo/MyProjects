package com.example.Backend;

import com.example.Data.RegisterDatabase;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ErrorMessage="error";
        String PassError = "error";
        String NullError = "error";
        while (!ErrorMessage.equals("Account was created!")) {
                String newUsername = request.getParameter("newUsername");
                String newEmail = request.getParameter("newEmail");
                String newPassword = request.getParameter("newPassword");
                String newConfirmPassword = request.getParameter("ConfirmPassword");
                if (newUsername.equals("") || newEmail.equals("") || newPassword.equals("") || newConfirmPassword.equals("")) {
                    NullError = "You need to complete all the fields";
                    request.setAttribute("NullError", NullError);
                } else if (!newPassword.equals(newConfirmPassword)) {
                    PassError = "The password don't much!";
                    request.setAttribute("passwordError", PassError);
                }else{
                    ErrorMessage = RegisterDatabase.insertAccount(newUsername, newEmail, newPassword, newConfirmPassword);
                }
            if (ErrorMessage.equals("This Username already exist!")) {
                request.setAttribute("NullError", ErrorMessage);
            } else if (ErrorMessage.equals("This Account already exist!")) {
                request.setAttribute("NullError", ErrorMessage);
            }
            if(ErrorMessage.equals("This Username already exist!")||ErrorMessage.equals("This Account already exist!")|| PassError.equals("The password don't much!")||NullError.equals("You need to complete all the fields")){
                request.getRequestDispatcher("RegisterPage.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}





