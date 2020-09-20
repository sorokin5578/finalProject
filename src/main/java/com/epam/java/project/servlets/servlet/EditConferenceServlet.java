package com.epam.java.project.servlets.servlet;

import com.epam.java.project.dao.ConferenceDAO;
import com.epam.java.project.entity.Conference;
import com.epam.java.project.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class EditConferenceServlet extends HttpServlet {
    private AtomicReference<ConferenceDAO> conferences;
    private Conference conference;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        conferences = (AtomicReference<ConferenceDAO>) req.getServletContext().getAttribute("conferenceDAO");
        conference = conferences.get().getById(Integer.parseInt(req.getParameter("confId")));
        req.setAttribute("conference", conference);
        req.getRequestDispatcher("/WEB-INF/view/edit_conf.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String topic = req.getParameter("topic");
        String conferenceDate = req.getParameter("conferenceDate");
        Conference newConference = new Conference();
        newConference.setId(conference.getId());
        newConference.setName(name);
        newConference.setTopic(topic);
        newConference.setConferenceDate(conferenceDate);

        System.out.println(conferences.get().edit(newConference));
        System.out.println(conferences.get().store);
        resp.sendRedirect("/main_page");
//        req.getRequestDispatcher("/WEB-INF/view/main_menu.jsp").forward(req,resp);
    }
}
