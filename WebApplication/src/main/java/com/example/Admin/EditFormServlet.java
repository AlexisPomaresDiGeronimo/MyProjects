package com.example.Admin;

import com.example.Data.EditRegisterDatabase;
import com.example.Data.RegisterDatabase;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditFormServlet", value = "/EditFormServlet")
public class EditFormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ErrorMessage="error";
        String Error = "error";
        String PassError="error";
        String NullError="error";
        while (!ErrorMessage.equals("Account was created!")) {
            String Username = request.getParameter("Username");
            String editFormUsername = request.getParameter("editFormUser");
            String editFormEmail = request.getParameter("editFormEmail");
            String editFormPass = request.getParameter("editFormPass");
            if (editFormEmail.equals("") || editFormPass.equals("")) {
                Error = "You need to complete all the fields";
                request.setAttribute("Error", Error);
            }else{
                ErrorMessage = EditRegisterDatabase.insertEditAccount(Username,editFormUsername, editFormEmail, editFormPass);
            }
            if (ErrorMessage.equals("This Username already exist!")) {
                request.setAttribute("NullError", ErrorMessage);
            } else if (ErrorMessage.equals("This Account already exist!")) {
                request.setAttribute("NullError", ErrorMessage);
            }
            if(ErrorMessage.equals("This Username already exist!")||ErrorMessage.equals("This Account already exist!")|| PassError.equals("The password don't much!")||NullError.equals("You need to complete all the fields")){
                request.getRequestDispatcher("editPage.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("AdminServlet").forward(request, response);
            }
        }
    }
}
