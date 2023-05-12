package src;

import java.awt.Color;
import java.io.IOException;

public class Commands {
   public static Light light1;
   public static Light light2;
   public static Light light3;
   
   public static void parseCommandLine(String[] args) throws IOException {
      switch (args[0]) {
         case "setColor":
            if (args[1] != null) {
               if (args.length == 2) {
                  setColor(args[1]);
               } else {
                  setColor(args[1], args[2]);
               }
            } else {
               System.out.println("Sorry, but that is an invalid color.  Please enter one of the commands listed under the help tab.");
            }
            break;
            
         case "setBrightness":
            if (args.length == 2) {
               setBrightness(args[1]);
            } else {
               setBrightness(args[1], args[2]);
            }
            break;

         case "on":
            if (args.length == 1) {
               on();
            } else {
               on(args[1]);
            }
            break;

         case "off":
            if (args.length == 1) {
               off();
            } else {
               off(args[1]);
            }
            break;

         case "exit":
            exit();
            break;

         case "help":
            getHelp();
            break;

         default:
            System.out.println("Sorry, but that is an invalid command.  Please enter one of the commands listed under the help tab.");
      }
   }

   public static void setColor(String color) throws IOException {
      try {
         Color rgb = Color.decode(color);
         
         light1.setColor(rgb);
         light2.setColor(rgb);
         light3.setColor(rgb);
      } catch (NumberFormatException e) {
         System.out.println("Sorry, but that is an invalid color.  Please enter one of the commands listed under the help tab.");
      }
   }
   
   public static void setColor(String color, String light) throws IOException {
      try {
         Color rgb = Color.decode(color);
         
         switch(light) {
            case "light1":
               light1.setColor(rgb);
               break;
            case "light2":
               light2.setColor(rgb);
               break;
            case "light3":
               light3.setColor(rgb);
               break;
            default:
               System.out.println("Sorry, but that is an invalid light name.  Please enter \"light1\", \"light2\", or \"light3\".");
         }
      } catch (NumberFormatException e) {
         System.out.println("Sorry, but that is an invalid color.  Please enter one of the commands listed under the help tab.");
      }
   }
   
   public static void setBrightness(String brightness) throws IOException {
      try {
         int value = Integer.parseInt(brightness);
         if (value > 100 || value < 1) throw new IOException("");

         light1.setBrightness(value);
         light2.setBrightness(value);
         light3.setBrightness(value);
      } catch (NumberFormatException e) {
         System.out.println("Sorry, but that is an invalid color.  Please enter a valid number.");
      } catch (IOException e) {
         System.out.println("Sorry, but that is an invalid brightness level.  Please enter a number between 1 and 100.");
      }
   }
   
   public static void setBrightness(String brightness, String light) throws IOException {
      try {
         int value = Integer.parseInt(brightness);
         if (value > 100 || value < 1) throw new IOException("");

         switch (light) {
            case "light1":
               light1.setBrightness(value);
               break;
            case "light2":
               light2.setBrightness(value);
               break;
            case "light3":
               light3.setBrightness(value);
               break;
            default:
               System.out.println("Sorry, but that is an invalid light name.  Please enter \"light1\", \"light2\", or \"light3\".");
         }
      } catch (NumberFormatException e) {
         System.out.println("Sorry, but that is an invalid color.  Please enter a valid number.");
      } catch (IOException e) {
         System.out.println("Sorry, but that is an invalid brightness level.  Please enter a number between 1 and 100.");
      }
   }
   
   public static void on() throws IOException {
      light1.setState(true);
      light2.setState(true);
      light3.setState(true);
   }
   
   public static void on(String light) throws IOException {
      switch (light) {
         case "light1":
            light1.setState(true);
            break;
         case "light2":
            light2.setState(true);
            break;
         case "light3":
            light3.setState(true);
            break;
         default:
            System.out.println("Sorry, but that is an invalid light name.  Please enter \"light1\", \"light2\", or \"light3\".");
      }
   }
   
   public static void off() throws IOException {
      light1.setState(false);
      light2.setState(false);
      light3.setState(false);
   }
   
   public static void off(String light) throws IOException {
      switch (light) {
         case "light1":
            light1.setState(false);
            break;
         case "light2":
            light2.setState(false);
            break;
         case "light3":
            light3.setState(false);
            break;
         default:
            System.out.println("Sorry, but that is an invalid light name.  Please enter \"light1\", \"light2\", or \"light3\".");
      }
   }
      
   public static void exit() {
      System.exit(0);
   }
   
   public static void getHelp() {
      System.out.println("   setColor color [light] - Changes the color of the lights to the hex code interperted from color.");
      System.out.println("      -color : A string representation of a hex code.  Example: \"#00ff00\"");
      System.out.println("      -light [Optional] : A string representation of one of the three lights.  If null, the message will be sent to all of the lights.  Example: \"light1\"");
      System.out.println();
      System.out.println("   setBrightness brightness [light] - Changes the brightness of the lights to the integer interperted from brightness.");
      System.out.println("      -brightness : An integer representation of the intended brightness. Example: \"50\"");
      System.out.println("      -light [Optional] : A string representation of one of the three lights.  If null, the message will be sent to all of the lights.  Example: \"light1\"");
      System.out.println();
      System.out.println("   on [light] - Turns the lights on.");
      System.out.println("      -light [Optional] : A string representation of one of the three lights.  If null, the message will be sent to all of the lights.  Example: \"light1\"");
      System.out.println();
      System.out.println("   off [light] - Turns the lights off.");
      System.out.println("      -light [Optional] : A string representation of one of the three lights.  If null, the message will be sent to all of the lights.  Example: \"light1\"");
      System.out.println();
      System.out.println("   exit - Exits the program.  The lights stay on.");
   }
}