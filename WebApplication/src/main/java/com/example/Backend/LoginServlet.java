package com.example.Backend;

import com.example.Data.LoginDataClass;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String message="error";
        String NullError;
        while (!message.equals("You are logged in!!")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if(username.equals("")||password.equals("")){
                NullError ="You need to complete all the fields";
                request.setAttribute("loginError",NullError);
            }
            message= LoginDataClass.checkIfAccountExist(username,password);
            if(message.equals("You are logged in!!")){
                NullError = username;
                request.setAttribute("username",NullError);
                getServletContext().getRequestDispatcher("/Welcome.jsp").forward(request, response);
            }else if(username.equals("Admin") && password.equals("Admin")){
                message="You are logged in!!";
                getServletContext().getRequestDispatcher("/AdminServlet").forward(request, response);
            }
            else{
                request.setAttribute("NullError",message);
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }
}
