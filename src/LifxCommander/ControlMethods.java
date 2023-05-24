package src.LifxCommander;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class ControlMethods {
   static public void sendBroadcastMessage(byte[] messageByteArray, int port) throws IOException {
      DatagramSocket socket = new DatagramSocket();
      socket.setBroadcast(true);
      
      Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
      while(interfaces.hasMoreElements()) {
         NetworkInterface networkInterface = interfaces.nextElement();
         
         if(networkInterface.isUp() && !networkInterface.isLoopback()) {
            for(InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
               InetAddress broadcast = interfaceAddress.getBroadcast();
               if(broadcast != null) {
                  DatagramPacket packet = new DatagramPacket(messageByteArray, messageByteArray.length, broadcast, port);
                  socket.send(packet);
               }
            }
         }
      }
      socket.close();
   }
   
   static public void sendUdpMessage(byte[] messageByteArray, String ipAddress, int port) throws IOException {
      InetAddress address = InetAddress.getByName(ipAddress);
      DatagramSocket socket = new DatagramSocket();
      DatagramPacket packet = new DatagramPacket(messageByteArray, messageByteArray.length, address, port);
      socket.send(packet);
      socket.close();	
   }	
}