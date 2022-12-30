package GUI.Add;

import GUI.Utils.HttpURLConnection;
import GUI.Utils.JsonHelper;
import GUI.requestbody.UserBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddUser {
    private JPanel panel1;
    private JButton acceptButton;
    private JButton cancelButton;
    private JRadioButton SetRole1;
    private JRadioButton SetRole2;
    private JTextField LoginField;
    private JPasswordField PassField;
    private JTextField NameField;


    public AddUser(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame("Добавить пользователя");
        frame.setSize(380, 320);
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        ActionListener cancelListener = e -> {
            frame.setVisible(false);

        };
        cancelButton.addActionListener(cancelListener);

        ActionListener acceptListener = e -> {
            String login = LoginField.getText();
            String pswrd = PassField.getPassword().toString();
            String fio = NameField.getText();
            UserBody userBody = new UserBody();
            userBody.setLogin(login);
            userBody.setPswrd(pswrd);
            userBody.setFio(fio);
            int role;
            int ans;
            if (SetRole1.isSelected()) {
                role = 1;
            } else {
                role = 2;
            }
            userBody.setRole(role);
            String json = "";
            try {
                json = JsonHelper.UserToJSON(userBody);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
            try {
                ans = HttpURLConnection.sendPOST(json, "/addUser");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.setVisible(false);


        };
        acceptButton.addActionListener(acceptListener);
    }

}
