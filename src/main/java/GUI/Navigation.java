package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Navigation {
    private JLabel navigate;
    private JButton administrationButton;
    private JButton departmentButton;
    private JButton studentButton;
    private JPanel rootPanel;

    public Navigation(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame();
        frame.setMinimumSize(minDimension);
        frame.setSize(640, 480);
        frame.setContentPane(rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // navigate.setText("Choose you ...");


        ActionListener departmentListener = e -> {
            new DepartmentList(minDimension, frame);
            frame.setVisible(false);
        };
        departmentButton.addActionListener(departmentListener);

        ActionListener administrationListener = e -> {
            new DepartmentList(minDimension, frame);
            frame.setVisible(false);
        };
        administrationButton.addActionListener(administrationListener);

        ActionListener studentListener = e -> {
            new DepartmentList(minDimension, frame);
            frame.setVisible(false);
        };
        studentButton.addActionListener(studentListener);
    }
}