package GUI;

import GUI.Add.AddDepartment;
import GUI.Delete.DeleteDepartment;
import GUI.Update.UpdDepartment;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DepartmentList {
    private JPanel panel1;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JList list1;
    private JButton backButton;
    private JButton nextButton;


    public DepartmentList(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Список кафедр");
        frame.setMinimumSize(minDimension);
        frame.setSize(640, 480);
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JList list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollableList = new JScrollPane(list);

        ActionListener openListener = e -> {
            list.getSelectedValue();
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
            new SpecialityList(minDimension, frame);

        };
        nextButton.addActionListener(nextListener);

        ActionListener addListener = e -> {
            new AddDepartment(minDimension, frame);

        };
        addButton.addActionListener(addListener);

        ActionListener delListener = e -> {
            new DeleteDepartment(minDimension, frame);

        };
        deleteButton.addActionListener(delListener);

        ActionListener updListener = e -> {
            new UpdDepartment(minDimension, frame);

        };
        updateButton.addActionListener(updListener);
    }
}
