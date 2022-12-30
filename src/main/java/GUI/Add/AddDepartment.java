package GUI.Add;

import GUI.Utils.HttpURLConnection;
import GUI.Utils.JsonHelper;
import GUI.requestbody.DepartmentBody;
import GUI.requestbody.UserBody;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddDepartment {
    private JButton acceptButton;
    private JTextField NameField;
    private JButton cancelButton;
    private JPanel panel1;
    public AddDepartment(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Добавить пользователя");
        frame.setSize(380, 320);
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        ActionListener cancelListener = e -> {
            frame.setVisible(false);

        };

        ActionListener acceptListener = e -> {

            DepartmentBody departmentBody = new DepartmentBody();
            departmentBody.setName(NameField.getText());
            String json = "";
            try {
                json = JsonHelper.DepartmentToJSON(departmentBody);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
            try {
                HttpURLConnection.sendPOST(json, "/addDepartment");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.setVisible(false);


        };
        acceptButton.addActionListener(acceptListener);
        cancelButton.addActionListener(cancelListener);
    }
}
