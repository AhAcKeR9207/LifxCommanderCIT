package src;

import java.awt.Color;
import java.io.IOException;
import java.util.*;

import src.GUI.LifxGUI;
import src.LifxCommander.*;

import src.Messages.Light.*;
import src.DataTypes.*;

public class Main extends Commands {
   public static Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) throws IOException {
      // Init
      System.out.println("Initializing...");
      ReceiveMessages receiveMessages = new ReceiveMessages(Constants.PORT);
      receiveMessages.start();

      System.out.println("Getting ips...");
      String[] ips = IPGrabber.getIps();
      light1 = new Light(ips[0], Color.white);
      light2 = new Light(ips[1], Color.white);
      light3 = new Light(ips[2], Color.white);

      System.out.println("Loading GUI...");
      new LifxGUI(light1.getPanel(), light2.getPanel(), light3.getPanel());
      
      System.out.println("Done!");
      
      on();

      System.out.println("For those of you who like to give manual input, don't worry!  You still have a few commands.");
      System.out.println("For instance, you can change the colors of the lights by entering in a hex code (ex. #00ff00).  You can also turn the lights on, off, and exit the program.");
      System.out.println("You can also specify a single light.  Their names are \"light1\", \"light2\", and \"light3\"");
      System.out.println("For a full list of commands, type \"help\" below.");
      while (true) {
         String input = scanner.nextLine();
         parseCommandLine(input.split(" "));
      }

      /*
      // Transition Color
      HSBK newColor = HSBK.RGBtoHSBK(new Color(255, 0, 0));
      SetWaveform setWaveform = new SetWaveform();
      setWaveform.setColor(newColor);
      setWaveform.setCycles(2);
      setWaveform.setIsTransient(true);
      setWaveform.setPeriod(4000);
      setWaveform.setWaveform(Constants.Waveforms.SINUSOID);
      Command changeColor = new Command(setWaveform);
      ControlMethods.sendBroadcastMessage(changeColor.getByteArray(), port);
      */
   }
}