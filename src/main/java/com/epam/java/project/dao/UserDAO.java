package com.epam.java.project.dao;


import com.epam.java.project.entity.Role;
import com.epam.java.project.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {//TODO replace list in databese

    public final List<User> store = new ArrayList<>();//TODO private
    private int lastId=0;

    public User getById(int id) {

        User result = new User();
        result.setId(-1);

        for (User user : store) {
            if (user.getId() == id) {
                result = user;
                break;
            }
        }

        return result;
    }

    public User getUserByLoginPassword(final String login, final String password) {

        User result = new User();
        result.setId(-1);

        for (User user : store) {
            if (user.getUsername().equals(login) && user.getPassword().equals(password)) {
                result = user;
                break;
            }
        }

        return result;
    }

    public boolean add(final User user) {

        for (User u : store) {
            if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }
        user.setId(lastId++);
        return store.add(user);
    }

    public Role getRoleByLoginPassword(final String login, final String password) {
        Role result = Role.UNKNOWN;

        for (User user : store) {
            if (user.getUsername().equals(login) && user.getPassword().equals(password)) {
                result = user.getRole();
                break;
            }
        }

        return result;
    }

    public boolean userIsExist(final String login, final String password) {

        boolean result = false;

        for (User user : store) {
            if (user.getUsername().equals(login) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }

        return result;
    }
}