package com.coding.tasks.leetcode.top.interview.questions.easy.math;

public class PowerOfThree {

   public static void main(String[] args) {
      System.out.println(isPowerOfThree(10));
      System.out.println(isPowerOfThree(27));
   }

   private static boolean isPowerOfThree(int n) {
      if (n < 1) {
         return false;
      }

      while (n % 3 == 0) {
         n = n / 3;
      }

      return n == 1;
   }
}
