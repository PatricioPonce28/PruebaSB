package org.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Login Para Ingresar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login loginPanel = new Login();
        frame.setContentPane(loginPanel);
        frame.setSize(800, 600);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setVisible(true);
    }
}

