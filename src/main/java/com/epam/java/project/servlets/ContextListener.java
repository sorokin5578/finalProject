package com.epam.java.project.servlets;

import com.epam.java.project.dao.ConferenceDAO;
import com.epam.java.project.dao.UserDAO;
import com.epam.java.project.entity.Conference;
import com.epam.java.project.entity.Role;
import com.epam.java.project.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.atomic.AtomicReference;

public class ContextListener implements ServletContextListener {//TODO replace to real bd

    private AtomicReference<UserDAO> dao;
    private AtomicReference<ConferenceDAO> conferenceDAO;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        dao = new AtomicReference<>(new UserDAO());

        dao.get().add(new User(1, "u", "1", true, Role.ADMIN));
        dao.get().add(new User(2, "u2", "2", true, Role.USER));
        dao.get().add(new User(3, "u3", "3", true, Role.SPEAKER));

        final ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("dao", dao);

        conferenceDAO = new AtomicReference<>(new ConferenceDAO());
        conferenceDAO.get().add(new Conference("java summer", "java", "18:00 20-08-2020", dao.get().store.get(2)));
        conferenceDAO.get().add(new Conference("python summer", "python", "20:00 21-08-2020", dao.get().store.get(2)));
        servletContext.setAttribute("conferenceDAO", conferenceDAO);
        System.out.println(conferenceDAO.get().store);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {//TODO close bd connection
        dao = null;
        System.out.println("daoNull");
    }
}
