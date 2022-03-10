package com.coding.tasks.leetcode.top.interview.questions.medium.math;

public class SqrtX {

   public static void main(String[] args) {
      System.out.println(mySqrt(4));
      System.out.println(mySqrt(8));
      System.out.println(mySqrt(81));
      System.out.println(mySqrt(80));
   }

   private static int mySqrt(int x) {
      if (x == 0) {
         return 0;
      } else if (x < 4) {
         return 1;
      } else if (x < 9) {
         return 2;
      } else if (x < 15) {
         return 3;
      }

      int ans = 4;
      int dif = 11;
      long cur = 24;

      while (x > cur) {
         cur += dif;
         dif += 2;
         ans++;
      }

      return ans;
   }
}
