package com.coding.tasks.leetcode.top.interview.questions.medium.math;

public class PowXN {

   public static void main(String[] args) {
      System.out.println(myPow(2.0, 3));
      System.out.println(myPow(2.0, -2));
   }

   private static double myPow(double x, int n) {
      if (n == 0) {
         return 1.0;
      }

      if (n < 0) {
         x = 1 / x;
         n = -n;
      }

      double ans = 1;
      double current = x;
      for (long i = n; i > 0; i /= 2) {
         if ((i % 2) == 1) {
            ans = ans * current;
         }
         current = current * current;
      }

      return ans;
   }
}
