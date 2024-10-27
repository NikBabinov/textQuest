package ru.mail.nikbabinov.main_quest.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ru.mail.nikbabinov.main_quest.entity.ConfigSession;

import java.io.IOException;

@WebFilter("/*")
public class SessionAttributeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        if (session == null || session.getAttribute("saveSearchObject") == null || session.getAttribute("MAX_NUMB_SAVE_OBJECTS") == null) {
            new ConfigSession(httpRequest).setConfig();
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
