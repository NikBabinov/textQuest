package ru.mail.nikbabinov.main_quest.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.JSONArray;
import ru.mail.nikbabinov.main_quest.service.UserFileManager;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/main_quest/views/registration.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder jsonData = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            jsonData.append(line);
        }
        JSONArray jsonArray = new JSONArray(jsonData.toString());
        String email = jsonArray.getString(0);
        String password = jsonArray.getString(1);
        if (UserFileManager.saveUsersToFile(request, email, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", email);
        } else {
            response.sendRedirect("/registration");
        }
    }
}
