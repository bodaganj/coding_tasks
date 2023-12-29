package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.math;

public class DivideTwoIntegers {

   public static void main(String[] args) {
      System.out.println(divide(10, 3));
   }

   public static int divide(int dividend, int divisor) {
      if (dividend == 0) {
         return 0;
      }
      if (Math.abs(divisor) > Math.abs(dividend)) {
         return 0;
      }

      int big = Math.abs(dividend);
      int small = Math.abs(divisor);

      int ans = 1;
      while (small + small < big) {
         small += small;
         ans += ans;
         if (Integer.MAX_VALUE - small < small) {
            return Integer.MAX_VALUE;
         }
      }

      if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
         return ans;
      } else {
         return -ans;
      }
   }
}
