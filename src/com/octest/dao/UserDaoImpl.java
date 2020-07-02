package com.octest.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.BeanException;
import com.octest.beans.User;

public class UserDaoImpl implements IUserDao {
    private DaoFactory daoFactory;

    UserDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void add(User user) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO names(firstname, lastname) VALUES(?, ?);");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());

            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
        	try {
                if (connection != null) {
                	connection.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException("Impossible de communiquer avec la base de données");
        } finally {
            try {
                if (connection != null) {
                	connection.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
    }

    @Override
    public List<User> list() throws DaoException {
        List<User> users = new ArrayList<User>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
        	connection = daoFactory.getConnection();
            statement = connection.createStatement();
            resultat = statement.executeQuery("SELECT firstname, lastname FROM names;");

            while (resultat.next()) {
                String firstName = resultat.getString("firstname");
                String lastName = resultat.getString("lastname");

                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);

                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException("Impossible de communiquer avec la base de données");
        } catch (BeanException e) {
            throw new DaoException("Les données de la base sont invalides");
        } finally {
            try {
                if (connection != null) {
                	connection.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
        return users;
    }

}