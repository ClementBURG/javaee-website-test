package com.octest.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.User;

public class Names {
	private Connection connection;
    
    public List<User> recupererUtilisateurs() {
        List<User> utilisateurs = new ArrayList<User>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connection.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT firstname, lastname FROM names;");

            // Récupération des données
            while (resultat.next()) {
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");
                
                User utilisateur = new User();
                utilisateur.setFirstName(firstname);
                utilisateur.setLastName(lastname);
                
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                	connection.close();
            } catch (SQLException ignore) {
            }
        }
        
        return utilisateurs;
    }
    
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/octest_javaee", "postgres", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void ajouterUtilisateur(User user) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO names(firstname, lastname) VALUES(?, ?);");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
