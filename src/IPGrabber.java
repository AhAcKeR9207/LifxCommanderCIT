package src;

import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class IPGrabber {
   public static String[] getIps() throws IOException {
      String[] ips = new String[3];
      
      Runtime run = Runtime.getRuntime();
      Process process = run.exec("powershell.exe ping 10.180.63.255;");
      process = run.exec("powershell.exe arp -a | select-string 'd0-73-d5' |% { $_.ToString().Trim().Split(' ')[0] }");
      process.getOutputStream().close();
      
      Scanner psOut = new Scanner(new InputStreamReader(process.getInputStream()));
      ips[0] = psOut.hasNext() ? psOut.nextLine() : null;
      ips[1] = psOut.hasNext() ? psOut.nextLine() : null;
      ips[2] = psOut.hasNext() ? psOut.nextLine() : null;
      
      psOut.close();
      return ips;
   }
}