package GUI;

import GUI.Add.AddPersonalData;
import GUI.Delete.DeleteUser;
import GUI.Update.UpdPersonalData;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PersonalData {


    private JPanel panel1;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JList list1;
    private JButton backButton;
    private JButton openButton;
    private JButton nextButton;


    public PersonalData(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Личные данные");
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

        ActionListener deleteListener = e -> {
            new DeleteUser(minDimension, frame);
        };
        deleteButton.addActionListener(deleteListener);

        ActionListener addListener = e -> {
            new AddPersonalData(minDimension, frame);
        };
        addButton.addActionListener(addListener);

        ActionListener updateListener = e -> {
            new UpdPersonalData(minDimension, frame);
        };
        updateButton.addActionListener(updateListener);

        ActionListener nextListener = e -> {
            frame.setVisible(false);
            new LessonData(minDimension, frame);

        };
        nextButton.addActionListener(nextListener);

    }

}
