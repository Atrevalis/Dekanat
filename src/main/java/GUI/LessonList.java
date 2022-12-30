package GUI;

import GUI.Add.AddLesson;
import GUI.Delete.DeleteLesson;
import GUI.Update.UpdLesson;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LessonList {

    private JPanel panel1;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JList list1;
    private JButton backButton;
    private JButton openButton;
    private JButton nextButton;


    public LessonList(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Предметы");
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
            new SemList(minDimension, frame);

        };
        backButton.addActionListener(backListener);

//        ActionListener nextListener = e -> {
//            frame.setVisible(false);
//            new SpecialityList(minDimension, frame);
//
//        };
//        nextButton.addActionListener(nextListener);

        ActionListener addListener = e -> {
            new AddLesson(minDimension, frame);

        };
        addButton.addActionListener(addListener);

        ActionListener updListener = e -> {
            new UpdLesson(minDimension, frame);

        };
        updateButton.addActionListener(updListener);

        ActionListener delListener = e -> {
            new DeleteLesson(minDimension, frame);

        };
        deleteButton.addActionListener(delListener);
    }

}