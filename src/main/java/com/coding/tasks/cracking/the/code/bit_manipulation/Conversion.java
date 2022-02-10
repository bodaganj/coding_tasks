package com.coding.tasks.cracking.the.code.bit_manipulation;

public class Conversion {

   public static void main(String[] args) {
      System.out.println(getNumberOfBitsYouNeedToFlip(29, 15)); // 11101 and 01111 -> 2
      System.out.println(getNumberOfBitsYouNeedToFlip(9, 4)); // 1001 and 0100 -> 3
   }

   private static int getNumberOfBitsYouNeedToFlip(int a, int b) {
      int value = a ^ b;

      int counter = 0;
      while (value != 0) {
         counter++;
         value &= (value - 1);
      }

      return counter;
   }
}
