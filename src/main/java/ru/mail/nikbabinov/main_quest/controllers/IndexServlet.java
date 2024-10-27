package ru.mail.nikbabinov.main_quest.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.mail.nikbabinov.main_quest.constants.ButtonText;
import ru.mail.nikbabinov.main_quest.constants.SpeechHeroPetka;
import ru.mail.nikbabinov.main_quest.constants.SpeechHeroVasiliy;
import ru.mail.nikbabinov.main_quest.entity.ConfigSession;

import java.io.IOException;

@WebServlet(name = "IndexServlet", value = "/")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new ConfigSession(req).cleanSession();

        String speechPetka = SpeechHeroPetka.INDEX_HTML_SPEECH_1.getSpeech();
        String speechVasiliy = SpeechHeroVasiliy.INDEX_HTML_SPEECH_1.getSpeech();
        String textStartButton = ButtonText.INDEX_HTML_START_BUTTON.getTextButton();

        req.setAttribute("speechPetka", speechPetka);
        req.setAttribute("speechVasiliy", speechVasiliy);
        req.setAttribute("textStartButton", textStartButton);

        req.getRequestDispatcher("/WEB-INF/main_quest/views/index.jsp").forward(req, resp);
    }
}
