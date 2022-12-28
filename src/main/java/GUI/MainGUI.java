package GUI;

import java.awt.*;

public class MainGUI {
    public static void main(String[] args) {
        Dimension minDimension = new Dimension();
        minDimension.height = 640;
        minDimension.width = 480;
//        new Navigation( minDimension, null);
        new LoginForm( minDimension, null);
    }
}
