package ru.mail.nikbabinov.main_quest.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.mail.nikbabinov.main_quest.constants.ButtonText;
import ru.mail.nikbabinov.main_quest.constants.SpeechHeroVasiliy;

import java.io.IOException;

@WebServlet(name = "EndStoryServlet", value = "/lastPage")
public class LastPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String buttonIndexHtml = ButtonText.LAST_HTML_INDEX_BUTTON.getTextButton();
        String speechVasiliy = SpeechHeroVasiliy.LAST_PAGE_HTML_SPEECH_1.getSpeech();

        req.setAttribute("buttonIndexHtml", buttonIndexHtml);
        req.setAttribute("speechVasiliy", speechVasiliy);
        req.getRequestDispatcher("/WEB-INF/main_quest/views/lastPage.jsp").forward(req, resp);
    }
}
