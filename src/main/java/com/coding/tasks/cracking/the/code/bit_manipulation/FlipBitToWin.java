package com.coding.tasks.cracking.the.code.bit_manipulation;

public class FlipBitToWin {

   public static void main(String[] args) {
      System.out.println(flip(5)); // 101 -> 3
      System.out.println(flip(20)); // 10100 -> 3
      System.out.println(flip(93)); // 1011101 -> 5
      System.out.println(flip(83)); // 1010011 -> 3
      System.out.println(flip(1775)); // 11011101111 -> 8
   }

   private static int flip(int a) {
      int max = Integer.MIN_VALUE;

      int counter = 0;
      boolean canWeAddOne = true;
      while (a > 0) {
         if ((a & 1) == 1) {
            counter++;
            max = Math.max(max, counter);
         } else {
            if (canWeAddOne) {
               canWeAddOne = false;
               counter++;
               max = Math.max(max, counter);
            } else {
               counter = 0;
               canWeAddOne = true;
            }
         }
         a >>= 1;
      }

      return max;
   }
}
