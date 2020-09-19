package com.epam.java.project.servlets;

import com.epam.java.project.dao.UserDAO;
import com.epam.java.project.entity.Role;
import com.epam.java.project.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.atomic.AtomicReference;

public class ContextListener implements ServletContextListener {//TODO replace to real bd

    private AtomicReference<UserDAO> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        dao = new AtomicReference<>(new UserDAO());

        dao.get().add(new User(1, "u", "1", true, Role.ADMIN));
        dao.get().add(new User(2, "u2", "2", true, Role.USER));

        final ServletContext servletContext = servletContextEvent.getServletContext();
        System.out.println("dao");
        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {//TODO close bd connection
        dao = null;
        System.out.println("daoNull");
    }
}
