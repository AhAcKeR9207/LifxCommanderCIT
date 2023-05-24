package src;

import java.awt.Color;
import java.io.IOException;

import src.GUI.LifxGUI;

public class Main {
   public static void main(String[] args) throws IOException, NullPointerException {
      String[] ips = IPGrabber.getIps();
      BroadcastLight lights = new BroadcastLight(Color.white);
      Light light1 = new Light(ips[0], Color.white);
      Light light2 = new Light(ips[1], Color.white);
      Light light3 = new Light(ips[2], Color.white);

      new LifxGUI(lights.getPanel(), light1.getPanel(), light2.getPanel(), light3.getPanel());
   }
}