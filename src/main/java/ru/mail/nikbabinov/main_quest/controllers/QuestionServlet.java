package ru.mail.nikbabinov.main_quest.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.mail.nikbabinov.main_quest.constants.SpeechHeroVasiliy;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "QuestionServlet", value = "/question")
public class QuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Set<String> saveSearchObject = (Set<String>) session.getAttribute("saveSearchObject");
        Integer MAX_NUMB_SAVE_OBJECTS = (Integer) session.getAttribute("MAX_NUMB_SAVE_OBJECTS");

        String speechVasiliy = SpeechHeroVasiliy.QUESTION_HTML_SPEECH_1.getSpeech();
        if (!saveSearchObject.isEmpty()) {
            speechVasiliy = SpeechHeroVasiliy.QUESTION_HTML_SPEECH_2.getSpeech();
        }
        if (saveSearchObject.size() == MAX_NUMB_SAVE_OBJECTS) {
            speechVasiliy = SpeechHeroVasiliy.QUESTION_HTML_SPEECH_3.getSpeech();
        }

        request.setAttribute("speechVasiliy", speechVasiliy);
        request.getRequestDispatcher("/WEB-INF/main_quest/views/question.jsp").forward(request, response);
    }
}
