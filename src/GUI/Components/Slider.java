package src.GUI.Components;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import src.Light;
import src.BroadcastLight;

public class Slider extends JPanel {
    public Slider(Light light) {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintLabels(true);

        slider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                light.setBrightness(value);
           }
        });

        add(slider);
        setAlignmentX(CENTER_ALIGNMENT);
        setBorder(BorderFactory.createTitledBorder("Brightness"));
    }
    
    public Slider(BroadcastLight light) {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintLabels(true);

        slider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                light.setBrightness(value);
           }
        });

        add(slider);
        setAlignmentX(CENTER_ALIGNMENT);
        setBorder(BorderFactory.createTitledBorder("Brightness"));
    }
}