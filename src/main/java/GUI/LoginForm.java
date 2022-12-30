package GUI;

import GUI.Utils.HttpURLConnection;
import GUI.Utils.JsonHelper;
import GUI.requestbody.UserBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;


public class LoginForm {
    private JButton loginButton;
    private JPanel rootPanel;
    private JPasswordField passwordField;
    private JTextField loginField;
    private JPanel buttonPanel;
    private JLabel loginLabel;
    private JLabel passwordLabel;


    public LoginForm(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame();
        frame.setMinimumSize(minDimension);
        frame.setSize(640, 480);

        loginLabel.setText("Please, insert login");
        passwordLabel.setText("Please, insert password");
        loginButton.setText("Login");
        frame.setContentPane(rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ActionListener loginListener = e -> {

            //потом убрать
            frame.setVisible(false);
            new Navigation(minDimension, frame);
//            frame.setVisible(false);

            UserBody userBody = new UserBody();
            userBody.setLogin(loginField.getText());
            userBody.setPswrd(String.valueOf(passwordField.getPassword()));
            int i = 0;
            String json = "";
            try {
                json = JsonHelper.UserToJSON(userBody);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
            try {
                i = HttpURLConnection.sendPOST(json, "/login");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            if (i == 202) {
                frame.setVisible(false);
                new Navigation(minDimension, frame);
            } else {
                frame.setVisible(false);
            }
        };
        loginButton.addActionListener(loginListener);
    }
    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayoutManager(7, 1, new Insets(0, 0, 0, 0), -1, -1));
        loginField = new JTextField();
        rootPanel.add(loginField, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        passwordField = new JPasswordField();
        rootPanel.add(passwordField, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        loginLabel = new JLabel();
        loginLabel.setText("Label");
        rootPanel.add(loginLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(buttonPanel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        loginButton = new JButton();
        loginButton.setEnabled(true);
        loginButton.setText("Button");
        buttonPanel.add(loginButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        passwordLabel = new JLabel();
        passwordLabel.setText("Label");
        rootPanel.add(passwordLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        rootPanel.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        rootPanel.add(spacer2, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

}