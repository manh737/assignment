package com.example.assignment.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (new String("manhnd").equals(username) && new String("123456").equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", "manhnd");
            response.sendRedirect("book/list");
        } else {
            String message = "Invalid email/password";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
