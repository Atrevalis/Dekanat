package GUI;

import javax.swing.*;
import java.awt.*;

public class DeleteUser {
    private JButton noButton;
    private JButton yesButton;
    private JLabel sureLabel;
    private JPanel panel1;


    public DeleteUser(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Удалить пользователя");
        frame.setSize(280, 280);
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        sureLabel.setText("Вы уверены?");

    }
}