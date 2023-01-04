package GUI;

import GUI.Add.AddUser;
import GUI.Delete.DeleteUser;
import GUI.Update.UpdUser;
import GUI.Utils.HttpURLConnection;
import GUI.Utils.JsonHelper;
import com.dekanat.dekanat.server.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.intellij.uiDesigner.core.AbstractLayout;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class AdministrationList extends JFrame {


    private JPanel content;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;

    private JList list;
    private JButton backButton;
    private JButton openButton;
    private JScrollPane scrollableList;


    public AdministrationList(Dimension minDimension, JFrame parent) throws IOException {

        JFrame frame = new JFrame();


        frame.setMinimumSize(minDimension);
        frame.setSize(640, 480);
        frame.setContentPane(content);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



//        String json = HttpURLConnection.sendGET("/listUser");
//
//        json = JsonHelper.replacer(json);
//        Type listOfMyClassObject = new TypeToken<ArrayList<User>>() {
//        }.getType();
//
//        Gson gson = new Gson();
//        ArrayList<User> outputList = gson.fromJson(json, listOfMyClassObject);
//
//        DefaultListModel<String> dlm = new DefaultListModel<String>();
//        for (User user : outputList) {
//            dlm.add(0, user.getLogin());
//        }
        frame.setLayout(new FlowLayout());
        String[] data1 = {"11111", "22222", "33333", "44444"};
        list = new JList(data1);
        scrollableList = new JScrollPane(list);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        content.add(new JScrollPane(list));
        list.setFixedCellHeight(15);
        list.setFixedCellWidth(400);


//        json = JsonHelper.replacer(json);


        ActionListener listListener = e -> {
            frame.setVisible(false);
            new Navigation(minDimension, frame);
        };

        // scrollableList.

        ActionListener backListener = e -> {
            frame.setVisible(false);
            new Navigation(minDimension, frame);

        };
        backButton.addActionListener(backListener);

        ActionListener addListener = e -> {
            new AddUser(minDimension, frame);
        };
        addButton.addActionListener(addListener);

        ActionListener updListener = e -> {
            new UpdUser(minDimension, frame);
        };
        updateButton.addActionListener(updListener);

        ActionListener delListener = e -> {
            new DeleteUser(minDimension, frame);

        };
        deleteButton.addActionListener(delListener);


    }
}