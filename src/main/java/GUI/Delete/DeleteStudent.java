package GUI.Delete;

import javax.swing.*;
import java.awt.*;

public class DeleteStudent {

    private JButton noButton;
    private JButton yesButton;
    private JLabel sureLabel;
    private JPanel panel1;


    public DeleteStudent(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Удалить пользователя");
        frame.setSize(280, 280);
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        sureLabel.setText("Вы уверены?");

    }
}
