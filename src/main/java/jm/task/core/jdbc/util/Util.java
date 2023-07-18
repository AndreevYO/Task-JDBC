package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    Class <Driver> driverClass = Driver.class;
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String pass = "123";
    private Util(){}
    public static Connection open (){
        try {
            return DriverManager.getConnection(url,username,pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
