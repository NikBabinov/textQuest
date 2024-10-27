package ru.mail.nikbabinov.main_quest.entity;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

public class ConfigSession {
    private final HttpServletRequest request;

    public ConfigSession(HttpServletRequest request) {
        this.request = request;
    }

    public void setConfig() {
        HttpSession session = request.getSession();

        Set<String> saveSearchObject = (Set<String>) session.getAttribute("saveSearchObject");

        if (saveSearchObject == null) {
            saveSearchObject = new HashSet<>();
        }

        Integer MAX_NUMB_SAVE_OBJECTS = (Integer) session.getAttribute("MAX_NUMB_SAVE_OBJECTS");

        if (MAX_NUMB_SAVE_OBJECTS == null) {
            MAX_NUMB_SAVE_OBJECTS = 2;
        }

        session.setAttribute("saveSearchObject", saveSearchObject);
        session.setAttribute("MAX_NUMB_SAVE_OBJECTS", MAX_NUMB_SAVE_OBJECTS);
    }

    public void cleanSession() {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("saveSearchObject");
            session.removeAttribute("MAX_NUMB_SAVE_OBJECTS");
        }
    }
}
