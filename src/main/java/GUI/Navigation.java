package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Navigation {
    private JLabel navigate;
    private JButton administrationButton;
    private JButton departmentButton;
    private JButton studentButton;
    private JPanel rootPanel;

//    private JButton studentsButton;

    public int role;

    public Navigation(Dimension minDimension, JFrame parent) {

        JFrame frame = new JFrame("Меню навигации");
        frame.setMinimumSize(minDimension);
        frame.setSize(640, 480);
        frame.setContentPane(rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Temporary.role = 1;

        ActionListener departmentListener = e -> {
            frame.setVisible(false);
            new DepartmentList(minDimension, frame);
        };
        departmentButton.addActionListener(departmentListener);

        ActionListener administrationListener = e -> {
            try {
                if (Temporary.role == 1) {
                    frame.setVisible(false);
                    new AdministrationList(minDimension, frame);
                } else {
                    navigate.setText("Недостаточно прав");
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        };
        administrationButton.addActionListener(administrationListener);

        ActionListener studentListener = e -> {
            frame.setVisible(false);
            new StudentsList(minDimension, frame);
        };
        studentButton.addActionListener(studentListener);
    }

}