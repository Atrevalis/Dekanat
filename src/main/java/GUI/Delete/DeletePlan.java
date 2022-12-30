package GUI.Delete;

import GUI.Navigation;
import GUI.Temporary;
import GUI.Utils.HttpURLConnection;
import GUI.Utils.JsonHelper;
import GUI.requestbody.LessonBody;
import GUI.requestbody.PlanBody;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeletePlan {


    private JButton noButton;
    private JButton yesButton;
    private JLabel sureLabel;
    private JPanel panel1;


    public DeletePlan(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Удалить план");
        frame.setSize(280, 280);
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        sureLabel.setText("Вы уверены?");


        ActionListener listListener = e -> {
            frame.setVisible(false);

            PlanBody planBody = new PlanBody();
            planBody.setId(Temporary.numPlan);

            String json = "";
            try {
                json = JsonHelper.PlanToJSON(planBody);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
            try {
                HttpURLConnection.sendPOST(json, "/deletePlan");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            new Navigation(minDimension, frame);
        };

        yesButton.addActionListener(listListener);

    }
}
