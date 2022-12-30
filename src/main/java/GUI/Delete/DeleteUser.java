package GUI.Delete;

import GUI.Navigation;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
        ActionListener noListener = e -> {
            frame.setVisible(false);
        };
        ActionListener dListener = e -> {

            frame.setVisible(false);

        };
        noButton.addActionListener(noListener);

        };
    }

