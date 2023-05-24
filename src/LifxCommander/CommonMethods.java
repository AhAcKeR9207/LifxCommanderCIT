package src.LifxCommander;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class CommonMethods {
   public static byte[] convertBinaryStringToLittleEndianByteArray(String binValueAsString) {
      if (binValueAsString.length() % 8 == 0) {
         byte[] byteArray = new byte[binValueAsString.length() / 8];
         long binaryToLong = Long.parseLong(binValueAsString, 2);
         ByteBuffer byteBuffer = ByteBuffer.allocate(8);
         byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
         byteBuffer.putLong(binaryToLong);
         
         for (int i = 0; i < byteArray.length; i++) byteArray[i] = byteBuffer.array()[i];

         return byteArray;
      }
      
      return null;
   }
}