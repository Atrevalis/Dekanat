package GUI;

import GUI.Add.AddSpeciality;
import GUI.Delete.DeleteSpeciality;
import GUI.Update.UpdSpec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SpecialityList {
    private JPanel panel1;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton backButton;
    private JButton nextButton;
    private JTextArea a23332123TextArea;


    public SpecialityList(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Специальности");
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
            new DepartmentList(minDimension, frame);

        };
        backButton.addActionListener(backListener);

        ActionListener nextListener = e -> {
            frame.setVisible(false);
            new PlanList(minDimension, frame);

        };
        nextButton.addActionListener(nextListener);

        ActionListener addListener = e -> {
            new AddSpeciality(minDimension, frame);

        };
        addButton.addActionListener(addListener);

        ActionListener delListener = e -> {
            new DeleteSpeciality(minDimension, frame);

        };
        deleteButton.addActionListener(delListener);

        ActionListener updListener = e -> {
            new UpdSpec(minDimension, frame);

        };
        updateButton.addActionListener(updListener);

    }

}