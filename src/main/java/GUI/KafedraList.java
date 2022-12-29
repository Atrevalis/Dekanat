package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class KafedraList {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JList list1;
    private JButton backButton;


    public KafedraList(Dimension minDimension, JFrame parent) {
        JFrame frame = new JFrame();
        frame.setMinimumSize(minDimension);
        frame.setSize(640, 480);
        frame.setContentPane(panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JList list = new JList();
        JScrollPane scrollableList = new JScrollPane(list);








        ActionListener backListener = e -> {
            new Navigation(minDimension, frame);
            frame.setVisible(false);
        };
        backButton.addActionListener(backListener);

    }





}
