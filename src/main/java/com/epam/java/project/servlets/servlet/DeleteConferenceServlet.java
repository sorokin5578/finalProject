package com.epam.java.project.servlets.servlet;

import com.epam.java.project.dao.ConferenceDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class DeleteConferenceServlet extends HttpServlet {
    private AtomicReference<ConferenceDAO> conferences;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        conferences = (AtomicReference<ConferenceDAO>) req.getServletContext().getAttribute("conferenceDAO");
        int id=Integer.parseInt(req.getParameter("confId"));
        System.out.println(id);
        conferences.get().delete(id);
        resp.sendRedirect("/main_page");
//        req.getRequestDispatcher("/WEB-INF/view/main_menu.jsp").forward(req,resp);
    }
}
