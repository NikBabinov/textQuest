package ru.mail.nikbabinov.main_quest.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.mail.nikbabinov.main_quest.service.UserFileManager;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/main_quest/views/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("login__email");
        String password = request.getParameter("login__password");
        if (UserFileManager.readUsersFromFile(request, email, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", email);
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/registration");
        }
    }
}
