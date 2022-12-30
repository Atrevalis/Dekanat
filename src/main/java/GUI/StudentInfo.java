package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StudentInfo {

    private JPanel panel1;
    private JList list1;
    private JButton backButton;
    private JButton nextButton;


    public StudentInfo(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame();
        frame.setMinimumSize(minDimension);
        frame.setSize(640, 480);
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JList list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollableList = new JScrollPane(list);

        ActionListener listListener = e -> {
            frame.setVisible(false);
            new Navigation(minDimension, frame);
        };

        // scrollableList.

        ActionListener backListener = e -> {
            frame.setVisible(false);
            new Navigation(minDimension, frame);

        };
        backButton.addActionListener(backListener);

        ActionListener nextListener = e -> {
            frame.setVisible(false);
            new PersonalData(minDimension, frame);

        };
        nextButton.addActionListener(nextListener);

    }
}
