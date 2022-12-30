package GUI.Delete;

import GUI.Navigation;
import GUI.Temporary;
import GUI.Utils.HttpURLConnection;
import GUI.Utils.JsonHelper;
import GUI.requestbody.DepartmentBody;
import GUI.requestbody.LessonBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

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
            lessonBody.setId(Temporary.lessonId);

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
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        noButton = new JButton();
        noButton.setText("Button");
        panel1.add(noButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        yesButton = new JButton();
        yesButton.setText("Button");
        panel1.add(yesButton, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sureLabel = new JLabel();
        sureLabel.setHorizontalAlignment(10);
        sureLabel.setText("Label");
        panel1.add(sureLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_SOUTHEAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
