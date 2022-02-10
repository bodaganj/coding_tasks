package com.coding.tasks.cracking.the.code.bit_manipulation;

public class SumTwoNumbers {

   public static void main(String[] args) {
      System.out.println(getSum(10, 3));
      System.out.println(getSum(4, 2));
      System.out.println(getSum(7, 3));
      System.out.println(getSum(-7, -3));
      System.out.println(getSum(-4, -2));
      System.out.println(getSum(-13, 7));
   }

   private static int getSum(int a, int b) {
      while (b != 0) {
         int value = a ^ b;
         int carry = a & b;
         a = value;
         b = carry << 1;
      }
      return a;
   }
}
