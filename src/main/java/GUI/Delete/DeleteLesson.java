package GUI.Delete;

import GUI.Navigation;
import GUI.Temporary;
import GUI.Utils.HttpURLConnection;
import GUI.Utils.JsonHelper;
import GUI.requestbody.DepartmentBody;
import GUI.requestbody.LessonBody;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteLesson {


    private JButton noButton;
    private JButton yesButton;
    private JLabel sureLabel;
    private JPanel panel1;


    public DeleteLesson(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Удалить предмет");
        frame.setSize(280, 280);
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        sureLabel.setText("Вы уверены?");

        ActionListener listListener = e -> {
            frame.setVisible(false);

            LessonBody lessonBody = new LessonBody();
            lessonBody.setId(Temporary.lesson);

            String json = "";
            try {
                json = JsonHelper.LessonToJSON(lessonBody);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
            try {
                HttpURLConnection.sendPOST(json, "/deleteLesson");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            new Navigation(minDimension, frame);
        };

        yesButton.addActionListener(listListener);

    }
}
