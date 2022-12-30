package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddUser {
    private JPanel panel1;
    private JButton acceptButton;
    private JButton cancelButton;
    private JRadioButton SetRole1;
    private JRadioButton SetRole2;
    private JTextField LoginField;
    private JPasswordField PassField;
    private JTextField NameField;

    public AddUser(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Добавить пользователя");
        frame.setSize(380, 320);
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        ActionListener cancelListener = e -> {
            frame.setVisible(false);

        };
        cancelButton.addActionListener(cancelListener);

        ActionListener acceptListener = e -> {
            frame.setVisible(false);

        };
        acceptButton.addActionListener(acceptListener);
    }
}
