package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Gestion extends  JPanel {
    private JTextField cedulaText;
    private JTextField nombreText;
    private JTextField call1Text;
    private JTextField call2Text;
    private JTextField call3Text;
    private JTextField call4Text;
    private JTextField call5Text;
    private JButton agregarButton;

    public Gestion() {
        JFrame frame = new JFrame("Gestión Estudiante");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(6, 2));

        cedulaText = new JTextField();
        nombreText = new JTextField();
        call1Text = new JTextField();
        call2Text = new JTextField();
        call3Text = new JTextField();
        call4Text = new JTextField();
        call5Text = new JTextField();
        agregarButton = new JButton("Agregar");

        frame.add(new JLabel("Cédula:"));
        frame.add(cedulaText);
        frame.add(new JLabel("Nombre:"));
        frame.add(nombreText);
        frame.add(new JLabel("Calificación 1:"));
        frame.add(call1Text);
        frame.add(new JLabel("Calificación 2:"));
        frame.add(call2Text);
        frame.add(new JLabel("Calificación 3:"));
        frame.add(call3Text);
        frame.add(new JLabel("Calificación 4:"));
        frame.add(call4Text);
        frame.add(new JLabel("Calificación 5:"));
        frame.add(call5Text);
        frame.add(agregarButton);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int cedula = Integer.parseInt(cedulaText.getText());
                    String nombre = nombreText.getText();
                    int calificacion1 = Integer.parseInt(call1Text.getText());
                    int calificacion2 = Integer.parseInt(call2Text.getText());
                    int calificacion3 = Integer.parseInt(call3Text.getText());
                    int calificacion4 = Integer.parseInt(call4Text.getText());
                    int calificacion5 = Integer.parseInt(call5Text.getText());

                    agregarEstudiante(cedula, nombre, calificacion1, calificacion2, calificacion3, calificacion4, calificacion5);

                    JOptionPane.showMessageDialog(frame, "Registro realizado con éxito.");
                    frame.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese valores válidos.");
                }
            }
        });

        frame.setVisible(true);
    }

    private void agregarEstudiante(int cedula, String nombre, int calificacion1, int calificacion2, int calificacion3, int calificacion4, int calificacion5) {
        String sql = "INSERT INTO estudiantes (cedula, nombre, estudiante1, estudiante2, estudiante3, estudiante4, estudiante5) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, cedula);
            preparedStatement.setString(2, nombre);
            preparedStatement.setInt(3, calificacion1);
            preparedStatement.setInt(4, calificacion2);
            preparedStatement.setInt(5, calificacion3);
            preparedStatement.setInt(6, calificacion4);
            preparedStatement.setInt(7, calificacion5);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar estudiante: " + e.getMessage());
        }
    }
}


