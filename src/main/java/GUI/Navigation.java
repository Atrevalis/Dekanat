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
    private JButton studentsButton;

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
            frame.setVisible(false);
            new DepartmentList(minDimension, frame);
        };
        departmentButton.addActionListener(departmentListener);

        ActionListener administrationListener = e -> {
            frame.setVisible(false);
            new DepartmentList(minDimension, frame);
        };
        administrationButton.addActionListener(administrationListener);

        ActionListener studentListener = e -> {
            frame.setVisible(false);
            new DepartmentList(minDimension, frame);
        };
        studentButton.addActionListener(studentListener);
    }
}