package GUI.Add;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddSem {
    private JButton acceptButton;
    private JTextField NameField;
    private JButton cancelButton;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;

    public AddSem(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Добавить пользователя");
        frame.setSize(380, 320);
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        ActionListener cancelListener = e -> {
            frame.setVisible(false);

        };
        cancelButton.addActionListener(cancelListener);
    }
}
