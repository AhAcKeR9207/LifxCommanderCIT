package src;

import java.awt.Color;
import java.io.IOException;
import javax.swing.*;

import src.DataTypes.*;
import src.GUI.Components.*;
import src.LifxCommander.ControlMethods;
import src.Messages.Light.*;

public class Light extends ControlMethods {
   private JPanel panel;
   private LightPane lightPane;
   private String ip;
   private Color color;
   private double brightness;
   private int state;
   
   public Light(String ip, Color color) {
      this.ip = ip;
      this.color = color;
      brightness = 1;
      state = Constants.Power.ON;
      
      lightPane = new LightPane() {};
      panel = new JPanel();
      panel.add(lightPane);
      panel.add(new ToggleButton(this));
      panel.add(new Slider(this));
      panel.add(new ColorButton(this));
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

      updateColor();
      updateState();
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
      if (state) {
         this.state = Constants.Power.ON;
      } else {
         this.state = Constants.Power.OFF;
      }
      updateState();
   }
   
   public String getIP() {
      return this.ip;
   }
   
   public Color getColor() {
      return this.color;
   }

   public JPanel getPanel() {
      return this.panel;
   }
   
   public boolean getState() {
      if (this.state == 0) {
         return true;
      }
   
      return false;
   }
   
   private void updateColor() {
      try {
         Color newColor = new Color(Math.max((int)(this.color.getRed() * brightness), 0),
                                    Math.max((int)(this.color.getGreen() * brightness), 0),
                                    Math.max((int)(this.color.getBlue() * brightness), 0));
         this.lightPane.setBulbColor(newColor);
         
         HSBK hsbk = HSBK.RGBtoHSBK(this.color);
         hsbk.setBrightness((int) (this.brightness * 65535.0));
         SetColor updateColor = new SetColor(hsbk);
         Command updateCommand = new Command(updateColor);
         sendUdpMessage(updateCommand.getByteArray(), this.ip, Constants.PORT);
      } catch (IOException e) {}
        catch (NullPointerException e) {}
   }
   
   private void updateState() {
      try {
         this.lightPane.setBulbColor(this.state != 0 ? this.color : Color.black);
         SetPower_Light updatePower = new SetPower_Light(this.state);
         Command updatePowerCommand = new Command(updatePower);
         sendUdpMessage(updatePowerCommand.getByteArray(), this.ip, Constants.PORT);
      } catch (IOException e) {}
        catch (NullPointerException e) {}
   }
}