package jm.task.core.jdbc;

import java.sql.*;
import java.sql.Connection;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.postgresql.Driver;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        UserServiceImpl usi = new UserServiceImpl();
//        usi.createUsersTable();
//
//        usi.saveUser("Vova","Korova", (byte) 13);
//        usi.saveUser("Vova1","Korova1", (byte) 14);
//        usi.saveUser("Vova2","Korova2", (byte) 15);
//        usi.saveUser("Vova3","Korova3", (byte) 16);
//
//        usi.getAllUsers();
//
//        usi.removeUserById(1);
//
//        usi.cleanUsersTable();
        usi.dropUsersTable();
    }
}