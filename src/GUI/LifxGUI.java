package src.GUI;

import javax.swing.*;

public class LifxGUI {
    public LifxGUI (JPanel light1, JPanel light2, JPanel light3) {
        JFrame frame = new JFrame("Lifx GUI");
        JPanel main = new JPanel();

        main.add(light1);
        main.add(light2);
        main.add(light3);

        main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));

        frame.add(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
       frame.setVisible(true);
    }
}