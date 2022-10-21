package com.example.Admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditServlet", value = "/EditServlet")
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ErrorMessage="error";
        String Error = "error";
        while (!ErrorMessage.equals("Account was created!")) {
            String editUsername = request.getParameter("editUsername");
            String editEmail = request.getParameter("editEmail");
            String editPass = request.getParameter("editPass");
            if (editUsername.equals("") || editEmail.equals("") || editPass.equals("")) {
                Error = "You need to complete all the fields";
                request.setAttribute("Error", Error);
            }else {
                request.setAttribute("editUsername", editUsername);
                request.setAttribute("editEmail", editEmail);
                request.setAttribute("editPass", editPass);
                getServletContext().getRequestDispatcher("/editPage.jsp").forward(request, response);
            }
        }
    }
}
