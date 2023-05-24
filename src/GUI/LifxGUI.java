package src.GUI;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.*;

import src.BroadcastLight;

public class LifxGUI extends JFrame {
    public LifxGUI (JPanel broadcast, JPanel light1, JPanel light2, JPanel light3) throws NullPointerException {
        setTitle("Lifx GUI");
        JPanel main = new JPanel();
        
        if (broadcast != null){ broadcast.setBorder(BorderFactory.createTitledBorder("Broadcast")); }
        if (light1 != null){ light1.setBorder(BorderFactory.createTitledBorder("light1")); }
        if (light2 != null){ light2.setBorder(BorderFactory.createTitledBorder("light2")); }
        if (light3 != null){ light3.setBorder(BorderFactory.createTitledBorder("light3")); }
  
        if (light1 != null){ main.add(broadcast); }
        if (light1 != null){ main.add(light1); }
        if (light2 != null){ main.add(light2); }
        if (light3 != null){ main.add(light3); }
        
        main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));

        add(main);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}