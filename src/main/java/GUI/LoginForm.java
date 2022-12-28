package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;


public class LoginForm {
    private JButton loginButton;
    private JPanel rootPanel;
    private JPasswordField passwordField;
    private JTextField loginField;
    private JPanel buttonPanel;
    private JLabel loginLable;
    private JLabel passwordLable;


    public LoginForm(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame();
        frame.setMinimumSize(minDimension);
        frame.setSize(640, 480);

        loginLable.setText("Please, insert login");
        passwordLable.setText("Please, insert password");
        loginButton.setText("Login");
        frame.setContentPane(rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ActionListener loginListener = e -> {
            new Navigation(minDimension, frame);
            frame.setVisible(false);
        };
        loginButton.addActionListener(loginListener);

    }


}