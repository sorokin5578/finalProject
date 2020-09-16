package com.epam.java.project.servlet;

import com.epam.java.project.entity.Conference;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GetIndexPageServlet extends HttpServlet {

    private static String index = "/WEB-INF/view/index.jsp";
    private List<Conference> conferences;

    @Override
    public void init() throws ServletException {
        conferences = new CopyOnWriteArrayList<>();
        conferences.add(new Conference("java summer","java", "18:00 20-08-2020"));
        conferences.add(new Conference("python summer","python", "20:00 21-08-2020"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {


            req.setAttribute("conferences", conferences);
            req.getRequestDispatcher(index).forward(req, resp);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        req.setCharacterEncoding("UTF8");

        if(!requestIsValid(req)){
            doGet(req,resp);
        }

        final String name = req.getParameter("name");
        final String topic = req.getParameter("topic");
        final String conferenceDate = req.getParameter("conferenceDate");

        final Conference conference = new Conference(name, topic, conferenceDate);

        conferences.add(conference);

            doGet(req, resp);
        }catch (ServletException| IOException e){
            e.printStackTrace();
        }
    }

    private boolean requestIsValid(HttpServletRequest req) {
        final String name = req.getParameter("name");
        final String topic = req.getParameter("topic");
        final String conferenceDate = req.getParameter("topic");//TODO regex for date

        return name != null && name.length() > 0 &&
                topic != null && topic.length() > 0 &&
                conferenceDate != null && conferenceDate.length() > 0;
    }


}