package src;

public class Constants {
   public static final int PORT = 56700;
   
   public class Levels {
      public static final int MIN = 0;
      public static final int MAX = 65535;
   }
   
   public class Power {
      public static final int ON = Levels.MAX;
      public static final int OFF = Levels.MIN;
   }
   
   public class Kelvin {
      public static final int WARMEST = 2500;
      public static final int MEDIUM = 4000;
      public static final int COOLEST = 9000;
   }
}