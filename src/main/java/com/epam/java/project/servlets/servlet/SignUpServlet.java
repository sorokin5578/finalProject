package com.epam.java.project.servlets.servlet;

import com.epam.java.project.dao.UserDAO;
import com.epam.java.project.entity.Role;
import com.epam.java.project.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{

            if(!requestIsValid(req)){
                doGet(req,resp);
            }

            final String username = req.getParameter("username");
            final String password = req.getParameter("password");


            final User user = new User(0,username ,password,true, Role.USER);

            final AtomicReference<UserDAO> dao = (AtomicReference<UserDAO>) req.getServletContext().getAttribute("dao");
            dao.get().add(user);
            System.out.println(dao.get().store);
            resp.sendRedirect("/");
        }catch (ServletException| IOException e){
            e.printStackTrace();
        }
    }

    private boolean requestIsValid(HttpServletRequest req) {
        final String name = req.getParameter("username");
        final String pass = req.getParameter("password");
        return name != null && name.length() > 0 &&
                pass != null && pass.length() > 0;
    }
}
