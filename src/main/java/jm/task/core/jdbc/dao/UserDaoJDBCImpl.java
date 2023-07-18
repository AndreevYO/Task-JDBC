package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS users
                (
                    id     SERIAL PRIMARY KEY,
                    name  VARCHAR(128) NOT NULL,
                    lastName   VARCHAR(128) NOT NULL,
                    age SMALLINT NOT NULL 
                );
                """;
        try (var connect = Util.open();
             var statement = connect.createStatement()){
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        String sql = """
                DROP TABLE IF EXISTS users
                
                """;
        try (var connect = Util.open();
             var statement = connect.createStatement()){
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = """
                INSERT INTO users(name, lastName, age)
                VALUES (?,?,?)
                """;
        try (var connect = Util.open();
             var statement = connect.prepareStatement(sql)){
            statement.setString(1,name);
            statement.setString(2,lastName);
            statement.setByte(3,age);
            statement.executeUpdate();
            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String sql = """
                DELETE FROM users
                WHERE id = ?
                """;
        try (var connect = Util.open();
             var statement = connect.prepareStatement(sql)){
            statement.setLong(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        String sql = """
                SELECT
                    name,
                    lastName,
                    age
                FROM users
                """;
        List <User> list = new ArrayList<>();
        try (var connect = Util.open();
             var statement = connect.createStatement()){

            var executeResult = statement.executeQuery(sql);
            while(executeResult.next()){
                String name = executeResult.getString("name");
                String lastName = executeResult.getString("lastName");
                byte age = executeResult.getByte("age");
                User user = new User(name,lastName,age);
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        System.out.println(list);
        return list;
    }

    public void cleanUsersTable() {
        String sql = """
                DELETE FROM users
                """;
        try (var connect = Util.open();
             var statement = connect.prepareStatement(sql)){

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
