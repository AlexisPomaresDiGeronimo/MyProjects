package com.example.Admin;

import com.example.Data.RegisterDatabase;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ErrorMessage="error";
        String PassError = "error";
        String NullError = "error";
        while (!ErrorMessage.equals("Account was created!")) {
            String addUsername = request.getParameter("addUsername");
            String addEmail = request.getParameter("addEmail");
            String addPassword = request.getParameter("addPassword");
            String addConfirmPassword = request.getParameter("ConfirmPassword");
            if (addUsername.equals("") || addEmail.equals("") || addPassword.equals("") || addConfirmPassword.equals("")) {
                NullError = "You need to complete all the fields";
                request.setAttribute("NullError", NullError);
            } else if (!addPassword.equals(addConfirmPassword)) {
                PassError = "The password don't much!";
                request.setAttribute("passwordError", PassError);
            }else{
                ErrorMessage = RegisterDatabase.insertAccount(addUsername, addEmail, addPassword, addConfirmPassword);
            }
            if (ErrorMessage.equals("This Username already exist!")) {
                request.setAttribute("NullError", ErrorMessage);
            } else if (ErrorMessage.equals("This Account already exist!")) {
                request.setAttribute("NullError", ErrorMessage);
            }
            if(ErrorMessage.equals("This Username already exist!")||ErrorMessage.equals("This Account already exist!")|| PassError.equals("The password don't much!")||NullError.equals("You need to complete all the fields")){
                request.getRequestDispatcher("Add-New-User.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("AdminServlet").forward(request, response);
            }
        }
    }
}
