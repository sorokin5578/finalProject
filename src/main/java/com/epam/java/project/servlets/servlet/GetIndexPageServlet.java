package com.epam.java.project.servlets.servlet;

import com.epam.java.project.dao.ConferenceDAO;
import com.epam.java.project.entity.Conference;
import com.epam.java.project.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class GetIndexPageServlet extends HttpServlet {

    private static String index = "/WEB-INF/view/main_menu.jsp";
    private AtomicReference<ConferenceDAO> conferences;

    @Override
    public void init() throws ServletException {
        System.out.println("init");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        conferences = (AtomicReference<ConferenceDAO>) req.getServletContext().getAttribute("conferenceDAO");
        req.setAttribute("conferences", conferences.get().store);
        req.getRequestDispatcher(index).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF8");
        System.out.println("doPost");
        if (!requestIsValid(req)) {
            doGet(req, resp);
        }

        final String name = req.getParameter("name");
        final String topic = req.getParameter("topic");
        final String conferenceDate = req.getParameter("conferenceDate");
        final User user = (User) req.getSession().getAttribute("user");
        final Conference conference = new Conference(name, topic, conferenceDate, user);
        conferences.get().add(conference);

        doGet(req, resp);
    }

    private boolean requestIsValid(HttpServletRequest req) {
        final String name = req.getParameter("name");
        final String topic = req.getParameter("topic");
        final String conferenceDate = req.getParameter("topic");//TODO regex for date
        System.out.println(name);
        return name != null && name.length() > 0 &&
                topic != null && topic.length() > 0 &&
                conferenceDate != null && conferenceDate.length() > 0;
    }


}