package GUI;

import GUI.Add.AddLesson;
import GUI.Add.AddRate;
import GUI.Delete.DeleteLesson;
import GUI.Update.UpdLesson;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LessonData {
    private JPanel panel1;
    private JList list1;
    private JButton backButton;
    private JButton nextButton;


    public LessonData(Dimension minDimension, JFrame parent) {
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
            new PersonalData(minDimension, frame);

        };
        backButton.addActionListener(backListener);

        ActionListener nextListener = e -> {
            new AddRate(minDimension, frame);

        };
        nextButton.addActionListener(nextListener);


    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}