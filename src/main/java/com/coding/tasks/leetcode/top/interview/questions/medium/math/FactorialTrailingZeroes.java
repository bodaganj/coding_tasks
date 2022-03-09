package com.coding.tasks.leetcode.top.interview.questions.medium.math;

public class FactorialTrailingZeroes {

   public static void main(String[] args) {
      System.out.println(trailingZeroes(3));
      System.out.println(trailingZeroes(5));
      System.out.println(trailingZeroes(0));
      System.out.println(trailingZeroes(7));
      System.out.println(trailingZeroes(13));
   }

   private static int trailingZeroes(int n) {
      int zeroCount = 0;
      while (n > 0) {
         n /= 5;
         zeroCount += n;
      }
      return zeroCount;
   }
}
