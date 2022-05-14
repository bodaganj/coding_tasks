package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.math;

public class PowXN {

   public static void main(String[] args) {
//      System.out.println(myPow(2.0, 3));
//      System.out.println(myPow(2.0, -2));
      System.out.println(myPow(2.0, -2147483648));
   }

   private static double myPow(double x, int n) {
      if (x == -1.0) {
         return n % 2 == 0 ? 1 : -1;
      } else if (x == 1.0) {
         return 1.0;
      } else if (n == 0) {
         return 1.0;
      } else if (n == Integer.MIN_VALUE) {
         return 0.0;
      } else if (n > 0) {
         return get(x, n);
      } else {
         return 1 / get(x, Math.abs(n));
      }
   }

   private static double get(double x, int n) {
      double product = 1;
      for (int i = 0; i < n; i++) {
         product *= x;
      }

      return product;
   }
}
