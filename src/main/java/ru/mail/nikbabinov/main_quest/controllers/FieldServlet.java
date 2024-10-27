package ru.mail.nikbabinov.main_quest.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.mail.nikbabinov.main_quest.constants.ButtonText;
import ru.mail.nikbabinov.main_quest.constants.SpeechHeroVasiliy;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "FieldServlet", value = "/field")
public class FieldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Set<String> saveSearchObject = (Set<String>) session.getAttribute("saveSearchObject");
        Integer MAX_NUMB_SAVE_OBJECTS =(Integer) session.getAttribute("MAX_NUMB_SAVE_OBJECTS");

        String saveObjects = String.join(",", saveSearchObject);
        String speechVasiliy = SpeechHeroVasiliy.FIELD_PAGE_HTML_SPEECH_1.getSpeech();
        String speechVasiliyNoHorse = SpeechHeroVasiliy.FIELD_PAGE_HTML_NO_HORSE.getSpeech();
        String sucessTakeHorse = SpeechHeroVasiliy.FIELD_PAGE_HTML_SUCESS_TAKE_HORSE.getSpeech();
        String takePointerNoHorse = SpeechHeroVasiliy.FIELD_PAGE_HTML_NO_HORSE_TAKE_POINTER.getSpeech();
        String buttonBack = ButtonText.FIELD_HTML_BACK_BUTTON.getTextButton();

        req.setAttribute("speechVasiliy", speechVasiliy);
        req.setAttribute("speechVasiliyNoHorse", speechVasiliyNoHorse);
        req.setAttribute("saveObject", saveObjects);
        req.setAttribute("sucessTakeHorse", sucessTakeHorse);
        req.setAttribute("takePointerNoHorse", takePointerNoHorse);
        req.setAttribute("maxNumbSaveObject", MAX_NUMB_SAVE_OBJECTS);
        req.setAttribute("buttonBack", buttonBack);
        req.getRequestDispatcher("/WEB-INF/main_quest/views/field.jsp").forward(req, resp);
    }
}
