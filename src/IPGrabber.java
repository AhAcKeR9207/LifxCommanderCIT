package src;

import java.io.*;
import java.util.*;

public class IPGrabber {
   public static String[] getIps() throws IOException {
      String[] ips = new String[3];
      
      Runtime run = Runtime.getRuntime();
      Process process = run.exec("powershell.exe ping 10.180.63.255; arp -a | select-string 'd0-73-d5' |% { $_.ToString().Trim().Split(' ')[0] }");
      process.getOutputStream().close();
      
      Scanner psOut = new Scanner(new InputStreamReader(process.getInputStream()));
      for (int i = 0; i < 11; i++) { // passes the ping output
         psOut.nextLine();
      }
      
      // Collects the remaining ips
      ips[0] = psOut.hasNext() ? psOut.nextLine() : null;
      ips[1] = psOut.hasNext() ? psOut.nextLine() : null;
      ips[2] = psOut.hasNext() ? psOut.nextLine() : null;
      System.out.println("Found ip: " + ips[0]);
      System.out.println("Found ip: " + ips[1]);
      System.out.println("Found ip: " + ips[2]);
            
      psOut.close();
      return ips;
   }
}