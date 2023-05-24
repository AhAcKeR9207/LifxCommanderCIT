package src.GUI.Components;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public abstract class LightPane extends JLayeredPane {
    private JPanel back1, back2, back3, back4;
    private JPanel bulb1, bulb2, bulb3, bulb4, bulb5, bulb6, bulb7;
    private JPanel decor1, decor2, decor3, decor4, decor5, decor6, decor7, decor8, decor9, decor10, decor11, decor12;

    public LightPane () {
        setPreferredSize(new Dimension(220, 190));
        int center = getPreferredSize().width / 2;
        makePanels(center);
        JPanel[] back = {back1, back2, back3, back4};
        for (int i = 0; i < back.length; i++) {
            add(back[i], 0);
        }

        JPanel[] bulbColor = {bulb1, bulb2, bulb3, bulb4, bulb5, bulb6, bulb7};
        for (int i = 0; i < bulbColor.length; i++) {
            add(bulbColor[i], 1);
        }

        JPanel[] decor = {decor1, decor2, decor3, decor4, decor5, decor6, decor7, decor8, decor9, decor10, decor11, decor12};
        for (int i = 0; i < decor.length; i++) {
            add(decor[i], 0);
        }

        setAlignmentX(CENTER_ALIGNMENT);
    }

    public void setBulbColor(Color color) {
        bulb1.setBackground(color);
        bulb2.setBackground(color);
        bulb3.setBackground(color);
        bulb4.setBackground(color);
        bulb5.setBackground(color);
        bulb6.setBackground(color);
        bulb7.setBackground(color);
    }

    public void makePanels(int center) {
        back1 = new Panel(center - 55, 140, 30, 40, Color.white);
        back2 = new Panel(center + 25, 140, 30, 40, Color.white);
        back3 = new Panel(center - 55, 0, 110, 140, Color.black);
        back4 = new Panel(center - 25, 140, 50, 40, Color.black);
        bulb1 = new Panel(center - 25, 10, 50, 10, Color.red);
        bulb2 = new Panel(center - 35, 20, 70, 10, Color.red);
        bulb3 = new Panel(center - 45, 30, 30, 60, Color.red);
        bulb4 = new Panel(center - 5, 30, 50, 60, Color.red);
        bulb5 = new Panel(center - 35, 90, 20, 20, Color.red);
        bulb6 = new Panel(center + 15, 90, 20, 20, Color.red);
        bulb7 = new Panel(center - 25, 100, 50, 30, Color.red);
        decor1 = new Panel(center - 55, 0, 30, 10, Color.white);
        decor2 = new Panel(center - 55, 0, 10, 30, Color.white);
        decor3 = new Panel(center + 25, 0, 30, 10, Color.white);
        decor4 = new Panel(center + 45, 0, 10, 30, Color.white);
        decor5 = new Panel(center - 55, 90, 10, 50, Color.white);
        decor6 = new Panel(center - 45, 110, 10, 30, Color.white);
        decor7 = new Panel(center - 35, 130, 10, 10, Color.white);
        decor8 = new Panel(center + 45, 90, 10, 50, Color.white);
        decor9 = new Panel(center + 35, 110, 10, 30, Color.white);
        decor10 = new Panel(center + 25, 130, 10, 10, Color.white);
        decor11 = new Panel(center - 15, 140, 30, 10, Color.white);
        decor12 = new Panel(center - 15, 160, 30, 10, Color.white);
    }
}