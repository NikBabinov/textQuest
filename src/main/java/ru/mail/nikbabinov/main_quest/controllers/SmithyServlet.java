package ru.mail.nikbabinov.main_quest.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "SmithyServlet", value = "/smithy")
public class SmithyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Set<String> saveSearchObject = (Set<String>) session.getAttribute("saveSearchObject");
        for (String saveObject : saveSearchObject) {
            req.setAttribute(saveObject, saveObject);
        }
        req.getRequestDispatcher("/WEB-INF/main_quest/views/smithy.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        saveSearchObjects(req);
    }

    private void saveSearchObjects(HttpServletRequest req) throws IOException {
        HttpSession session = req.getSession();

        Set<String> saveSearchObject = (Set<String>) session.getAttribute("saveSearchObject");

        StringBuilder jsonData = new StringBuilder();
        String line;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            jsonData.append(line);
        }
        JSONArray jsonArray = new JSONArray(jsonData.toString());
        for (int i = 0; i < jsonArray.length(); i++) {
            saveSearchObject.add(jsonArray.getString(i));
        }
    }
}