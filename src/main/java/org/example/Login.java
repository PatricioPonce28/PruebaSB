package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    public JLabel loginLabel;
    public JPanel LoginPanel;

    public Login() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = new String(passwordField1.getPassword());

                if (LoginValidation.validarUsuario(username, password)) {
                    loginLabel.setText("Acceso correcto");
                    JOptionPane.showMessageDialog(null, "Bienvenido, " + username);

                    new Gestion();

                } else {
                    loginLabel.setText("Usuario o contraseña incorrectos");
                }
            }
        });

    }


}