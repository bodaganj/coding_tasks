package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.math;

public class FactorialTrailingZeroes {

   public static void main(String[] args) {
      System.out.println(trailingZeroes(3));
      System.out.println(trailingZeroes(5));
      System.out.println(trailingZeroes(0));
      System.out.println(trailingZeroes(7));
      System.out.println(trailingZeroes(13));
   }

   private static int trailingZeroes(int n) {
      int sum = 1;
      for (int i = 1; i <= n; i++) {
         sum *= i;
      }

      System.out.println(sum);
      int count = 0;
      while (sum % 10 == 0) {
         count++;
         sum /= 10;
      }
      return count;
   }
}
