package src.GUI.Components;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JToggleButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import src.Light;
import src.BroadcastLight;

public class ToggleButton extends JToggleButton {
    public ToggleButton(Light light) {
        Border raisedResized = BorderFactory.createCompoundBorder(new BevelBorder(BevelBorder.RAISED), new EmptyBorder(10, 10, 10, 10));
        Border loweredResized = BorderFactory.createCompoundBorder(new BevelBorder(BevelBorder.LOWERED), new EmptyBorder(10, 10, 10, 10));
        Border active = BorderFactory.createCompoundBorder(new LineBorder(Color.black, 1), loweredResized);
        Border inactive = BorderFactory.createCompoundBorder(new LineBorder(Color.black, 1), raisedResized);

        setAlignmentX(CENTER_ALIGNMENT);
        setText("ON");
        setBorder(inactive);
        addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                if (isSelected()) {
                    setText("OFF");
                    setBorder(active);
                    light.setState(false);
                } else {
                    setText("ON");
                    setBorder(inactive);
                    light.setState(true);
                }
            }
        });
    }
    
    public ToggleButton(BroadcastLight light) {
        Border raisedResized = BorderFactory.createCompoundBorder(new BevelBorder(BevelBorder.RAISED), new EmptyBorder(10, 10, 10, 10));
        Border loweredResized = BorderFactory.createCompoundBorder(new BevelBorder(BevelBorder.LOWERED), new EmptyBorder(10, 10, 10, 10));
        Border active = BorderFactory.createCompoundBorder(new LineBorder(Color.black, 1), loweredResized);
        Border inactive = BorderFactory.createCompoundBorder(new LineBorder(Color.black, 1), raisedResized);

        setAlignmentX(CENTER_ALIGNMENT);
        setText("ON");
        setBorder(inactive);
        addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                if (isSelected()) {
                    setText("OFF");
                    setBorder(active);
                    light.setState(false);
                } else {
                    setText("ON");
                    setBorder(inactive);
                    light.setState(true);
                }
            }
        });
    }
}