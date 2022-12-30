package GUI.Add;

import GUI.Utils.HttpURLConnection;
import GUI.Utils.JsonHelper;
import GUI.requestbody.DepartmentBody;
import GUI.requestbody.LessonBody;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddLesson {
    private JButton acceptButton;
    private JTextField NameField;
    private JButton cancelButton;
    private JPanel panel1;
    private JTextField lecture;
    private JTextField lab;
    private JTextField index;
    private JTextField control;
    private JTextField prac;

    public AddLesson(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Добавить пользователя");
        frame.setSize(380, 320);
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ActionListener acceptListener = e -> {

            LessonBody lessonBody = new LessonBody();
            lessonBody.setName(NameField.getText());
            lessonBody.setControl(Integer.parseInt(control.getText()));
            lessonBody.setLectureH(lecture.getWidth());
            lessonBody.setLaboratoryH(Integer.parseInt(lab.getText()));
            lessonBody.setIndex(index.getText());
            lessonBody.setPractiseH(Integer.parseInt(prac.getText()));

            String json = "";
            try {
                json = JsonHelper.LessonToJSON(lessonBody);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
            try {
                HttpURLConnection.sendPOST(json, "/addLesson");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.setVisible(false);


        };

        ActionListener cancelListener = e -> {
            frame.setVisible(false);

        };
        cancelButton.addActionListener(cancelListener);
        acceptButton.addActionListener(acceptListener);
    }
}
