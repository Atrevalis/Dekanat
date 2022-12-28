package GUI;

import javax.swing.*;
import java.awt.*;

public class Navigation {
    private JLabel navigate;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel rootPanel;

    public Navigation(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame();
        frame.setMinimumSize(minDimension);
        frame.setSize(640, 480);
        frame.setContentPane(rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        navigate.setText("Choose you ...");
    }
}
