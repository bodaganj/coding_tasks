package com.coding.tasks.cracking.the.code.bit_manipulation;

public class NextSmallestAndNextLargest {

   public static void main(String[] args) {
      System.out.println(getLargest(4));
      System.out.println(getSmallest(4));
      System.out.println("------");
      System.out.println(getLargest(9));
      System.out.println(getSmallest(9));
      System.out.println("------");
   }

   private static int getLargest(int a) {
      // count all the 1s and put them at the right
      int counter = getAmountOf1s(a);
      int zeroCounter = 31 - counter;
      int value = 0;
      while (counter-- != 0) {
         value <<= 1;
         value ^= 1;
      }

      return value << zeroCounter;
   }

   private static int getSmallest(int a) {
      // count all the 1s and put them at the left
      int counter = getAmountOf1s(a);
      int value = 0;

      while (counter-- != 0) {
         value <<= 1;
         value ^= 1;
      }

      return value;
   }

   private static int getAmountOf1s(int a) {
      int counter = 0;
      while (a != 0) {
         counter++;
         a = a & (a - 1);
      }
      return counter;
   }
}
