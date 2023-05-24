package src;

import java.awt.Color;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import src.DataTypes.Command;
import src.DataTypes.HSBK;
import src.GUI.Components.ColorButton;
import src.GUI.Components.LightPane;
import src.GUI.Components.Slider;
import src.GUI.Components.ToggleButton;
import src.LifxCommander.ControlMethods;
import src.Messages.Light.SetColor;
import src.Messages.Light.SetPower_Light;

public class Light extends ControlMethods {
   private JPanel panel;
   private LightPane lightPane = new LightPane(){};
   private String ip;
   private Color color;
   private double brightness;
   private int state;
   
   public Light(String ip, Color color) {
      try {
         this.ip = ip;
         this.color = color;
         brightness = 1;
         state = Constants.Power.ON;
         
         panel = (ip != null) ? new JPanel() : null;
         
         panel.add(lightPane);
         panel.add(new ToggleButton(this));
         panel.add(new Slider(this));
         panel.add(new ColorButton(this));
         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
         
         updateColor();
         updateState();
      } catch (Exception e) {}
   }
   
   public void setColor(Color color) {
      this.color = color;
      updateColor();
   }
   
   public void setBrightness(int brightness) {
      this.brightness = brightness / 100.0;
      updateColor();
   }
   
   public void setState(boolean state) {
      this.state = state ? Constants.Power.ON : Constants.Power.OFF;
      updateState();
   }
   
   public String getIP() {
      return ip;
   }
   
   public Color getColor() {
      return color;
   }
   
   public JPanel getPanel() {
      return panel;
   }
   
   public boolean getState() {
      return state == 0;
   }
   
   private void updateColor() {
      try {
         Color newColor = new Color(Math.max((int)(color.getRed() * brightness), 0), Math.max((int)(color.getGreen() * brightness), 0), Math.max((int)(color.getBlue() * brightness), 0));
         lightPane.setBulbColor(newColor);
         
         HSBK hsbk = HSBK.RGBtoHSBK(color);
         hsbk.setBrightness((int) (brightness * 65535.0));
         SetColor updateColor = new SetColor(hsbk);
         Command updateCommand = new Command(updateColor);
         sendUdpMessage(updateCommand.getByteArray(), ip, Constants.PORT);
      } catch (IOException e) {} catch (NullPointerException e) {}
   }
   
   private void updateState() {
      try {
         lightPane.setBulbColor(state != 0 ? color : Color.black);
         
         SetPower_Light updatePower = new SetPower_Light(state);
         Command updatePowerCommand = new Command(updatePower);
         sendUdpMessage(updatePowerCommand.getByteArray(), ip, Constants.PORT);
      } catch (IOException e) {} catch (NullPointerException e) {}
   }
}