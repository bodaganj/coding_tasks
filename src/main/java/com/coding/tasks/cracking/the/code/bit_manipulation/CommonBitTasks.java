package com.coding.tasks.cracking.the.code.bit_manipulation;

public class CommonBitTasks {

   public static void main(String[] args) {
      System.out.println("Get bit:");
      System.out.println(getBit(5, 0));
      System.out.println(getBit(5, 1));
      System.out.println(getBit(5, 2));

      System.out.println("Set bit:");
      System.out.println(setBit(5, 1));

      System.out.println("Clear bit:");
      System.out.println(clearBit(5, 0));
      System.out.println(clearBit(5, 1));
      System.out.println(clearBit(5, 2));

      System.out.println("Toggle bit:");
      System.out.println(toggleBit(5, 0));
      System.out.println(toggleBit(5, 1));
      System.out.println(toggleBit(5, 2));

      System.out.println("Update bit:");
      System.out.println(updateBit(5, 1, 1));
      System.out.println(updateBit(5, 1, 0));
      System.out.println(updateBit(5, 2, 1));
      System.out.println(updateBit(5, 2, 0));
   }

   // get the current bit
   private static int getBit(int a, int i) {
      if ((a & (1 << i)) == 0) {
         return 0;
      } else {
         return 1;
      }
   }

   // set to 1
   private static int setBit(int a, int i) {
      return a | (1 << i);
   }

   // set to 0 or 1
   private static int updateBit(int a, int i, int bit) {
      a = clearBit(a, i);
      return a | (bit << i);
   }

   // set to 0
   private static int clearBit(int a, int i) {
      return a & (~(1 << i));
   }

   // change to another one
   private static int toggleBit(int a, int i) {
      return a ^ (1 << i);
   }
}
