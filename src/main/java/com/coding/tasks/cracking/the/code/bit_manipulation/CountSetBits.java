package com.coding.tasks.cracking.the.code.bit_manipulation;

public class CountSetBits {

   public static void main(String[] args) {
      System.out.println(getCountOfSetBits(5)); // 101
      System.out.println(getCountOfSetBits(4)); // 100
      System.out.println(getCountOfSetBits(0)); // 000
      System.out.println(getCountOfSetBits(11)); // 1011
      System.out.println();
      System.out.println(get2(5)); // 101
      System.out.println(get2(4)); // 100
      System.out.println(get2(0)); // 000
      System.out.println(get2(11)); // 1011
   }

   private static int getCountOfSetBits(int n) {
      int count = 0;
      while (n != 0) {
         count++;
         n &= (n - 1);
      }
      return count;
   }

   private static int get2(int n) {
      int bits = 0;
      int mask = 1;
      for (int i = 0; i < 32; i++) {
         if ((n & mask) != 0) {
            bits++;
         }
         mask <<= 1;
      }
      return bits;
   }
}
