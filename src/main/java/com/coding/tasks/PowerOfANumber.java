package com.coding.tasks;

public class PowerOfANumber {

   public static void main(String[] args) {
      System.out.println(power(2, 2));
      System.out.println(power(3, 3));
      System.out.println(power(2, 5));
      System.out.println("-------");
      System.out.println(powerRec(2, 2));
      System.out.println(powerRec(3, 3));
      System.out.println(powerRec(2, 5));
   }

   private static int power(int a, int b) {
      if (b == 0) {
         return 1;
      }
      if (b == 1) {
         return a;
      }
      int result = 1;
      for (int i = 1; i <= b; i++) {
         result *= a;
      }
      return result;
   }

   private static int powerRec(int a, int b) {
      if (b == 0) {
         return 1;
      }
      return a * powerRec(a, b - 1);
   }
}
