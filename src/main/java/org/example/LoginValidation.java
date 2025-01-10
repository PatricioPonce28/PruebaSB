package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginValidation {
        public static boolean validarUsuario(String username, String password) {
            String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";

            try (Connection connection = ConexionDB.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            } catch (SQLException e) {
                System.err.println("Error al validar usuario: " + e.getMessage());
                return false;
            }
        }
    }

