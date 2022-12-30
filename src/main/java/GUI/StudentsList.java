package GUI;

import GUI.Add.AddStudent;
import GUI.Delete.DeleteStudent;
import GUI.Update.UpdStudent;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StudentsList {
    private JPanel panel1;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JList list1;
    private JButton backButton;
    private JButton openButton;
    private JButton nextButton;


    public StudentsList(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Список студентов");
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
            new DeleteStudent(minDimension, frame);
        };
        deleteButton.addActionListener(deleteListener);

        ActionListener updListener = e -> {
            new UpdStudent(minDimension, frame);
        };
        updateButton.addActionListener(updListener);



        ActionListener addListener = e -> {
            new AddStudent(minDimension, frame);
        };
        addButton.addActionListener(addListener);

        ActionListener nextListener = e -> {
            frame.setVisible(false);
            new StudentInfo(minDimension, frame);
        };
        nextButton.addActionListener(nextListener);


        }


    }
