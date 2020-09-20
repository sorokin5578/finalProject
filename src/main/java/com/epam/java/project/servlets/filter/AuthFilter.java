package com.epam.java.project.servlets.filter;


import com.epam.java.project.dao.UserDAO;
import com.epam.java.project.entity.Role;
import com.epam.java.project.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;


public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String username = req.getParameter("username");
        final String password = req.getParameter("password");

        @SuppressWarnings("unchecked") final AtomicReference<UserDAO> dao = (AtomicReference<UserDAO>) req.getServletContext().getAttribute("dao");

        final HttpSession session = req.getSession();

        //Logged user.
        if (nonNull(session) &&
                nonNull(session.getAttribute("username")) &&
                nonNull(session.getAttribute("password"))) {

            final Role role = (Role) session.getAttribute("role");

            moveToMenu(req, res, dao.get().getUserByLoginPassword(
                    (String) session.getAttribute("username"),
                    (String) session.getAttribute("password")));


        } else if (dao.get().userIsExist(username, password)) {

            final Role role = dao.get().getRoleByLoginPassword(username, password);

            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("role", role);

            moveToMenu(req, res, dao.get().getUserByLoginPassword(username, password));

        } else {
            User user = new User();
            user.setRole(Role.UNKNOWN);
            moveToMenu(req, res, user);
        }
    }

    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'user' move to user menu.
     */
    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final User user)
            throws ServletException, IOException {

        if (user.getRole().equals(Role.UNKNOWN)) {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        } else {
            req.getSession().setAttribute("user", user);
            res.sendRedirect("/main_page");
        }
    }


    @Override
    public void destroy() {
    }

}