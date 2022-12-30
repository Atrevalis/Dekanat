package GUI.Delete;

import GUI.Navigation;
import GUI.Temporary;
import GUI.Utils.HttpURLConnection;
import GUI.Utils.JsonHelper;
import GUI.requestbody.DepartmentBody;
import GUI.requestbody.UserBody;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteDepartment {
    private JButton noButton;
    private JButton yesButton;
    private JLabel sureLabel;
    private JPanel panel1;


    public DeleteDepartment(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Удалить кафедру");
        frame.setSize(280, 280);
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        sureLabel.setText("Вы уверены?");

        ActionListener listListener = e -> {
            frame.setVisible(false);

            DepartmentBody departmentBody = new DepartmentBody();
            departmentBody.setId(Temporary.departmentId);

            String json = "";
            try {
                json = JsonHelper.DepartmentToJSON(departmentBody);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
            try {
                 HttpURLConnection.sendPOST(json, "/deleteDepartment");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            new Navigation(minDimension, frame);
        };

        yesButton.addActionListener(listListener);

    }
}
