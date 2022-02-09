package com.coding.tasks.cracking.the.code.bit_manipulation;

public class IntegerPowerOfTwo {

   public static void main(String[] args) {
      System.out.println(isIntegerPowerOfTwo(2));
      System.out.println(isIntegerPowerOfTwo(8));
      System.out.println(isIntegerPowerOfTwo(1));
      System.out.println(isIntegerPowerOfTwo(0));
      System.out.println(isIntegerPowerOfTwo(-4));
      System.out.println(isIntegerPowerOfTwo(7));
      System.out.println();
      System.out.println(isIntegerPowerOfTwo2(2));
      System.out.println(isIntegerPowerOfTwo2(8));
      System.out.println(isIntegerPowerOfTwo2(1));
      System.out.println(isIntegerPowerOfTwo2(0));
      System.out.println(isIntegerPowerOfTwo2(-4));
      System.out.println(isIntegerPowerOfTwo2(7));
   }

   // is it 2,4,8....
   private static boolean isIntegerPowerOfTwo(int a) {
      if (a <= 0) {
         return false;
      }
      int mask = 1;
      int count = 0;
      while (mask <= a) {
         if ((a & mask) != 0) {
            count++;
         }
         if (count > 1) {
            return false;
         }
         mask <<= 1;
      }
      return count == 1;
   }

   /**
    * Better solution!!!
    */
   private static boolean isIntegerPowerOfTwo2(int a) {
      if (a == 0) {
         return false;
      }
      long x = a;
      return (x & (x - 1)) == 0;
   }
}
