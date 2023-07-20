package jm.task.core.jdbc.service;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl us = new UserDaoJDBCImpl();
    UserDaoHibernateImpl ush = new UserDaoHibernateImpl();


    public void createUsersTable() {
//        us.createUsersTable();
        ush.createUsersTable();
    }

    public void dropUsersTable() {
//        us.dropUsersTable();
        ush.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
//        us.saveUser(name,lastName,age);
        ush.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
//        us.removeUserById(id);
        ush.removeUserById(id);
    }

    public List<User> getAllUsers() {
//        return us.getAllUsers();
        return ush.getAllUsers();
    }

    public void cleanUsersTable() {
//        us.cleanUsersTable();
        ush.cleanUsersTable();
    }
}
