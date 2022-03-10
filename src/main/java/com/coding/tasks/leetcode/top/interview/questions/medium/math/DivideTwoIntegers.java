package com.coding.tasks.leetcode.top.interview.questions.medium.math;

public class DivideTwoIntegers {

   public static void main(String[] args) {
      System.out.println(divide(8, 4));
      System.out.println(divide(7, -3));
      System.out.println(divide(1, 1));
      System.out.println(divide(-2147483648, -1));
   }

   private static int divide(int dividend, int divisor) {
      if (divisor == 1) {
         return dividend;
      }
      if (divisor == -1) {
         if (dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
         }
         return -dividend;
      }

      int ans = getAns(Math.abs(dividend), Math.abs(divisor));
      if ((divisor > 0 && dividend > 0) || (divisor < 0 && dividend < 0)) {
         return ans;
      } else {
         return -ans;
      }
   }

   private static int getAns(int dividend, int divisor) {
      int sum = divisor;

      for (int i = 1; i <= dividend; i++) {
         if (sum > dividend) {
            return i - 1;
         }
         sum += divisor;
      }

      return 0;
   }
}
