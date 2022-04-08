package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.dynamic_programming;

public class ClimbingStairs {

   public static void main(String[] args) {
      System.out.println(climbStairs(3));
      System.out.println(climbStairs(2));
   }

   private static int climbStairs(int n) {
      return recursion(n, new int[n + 1]);
   }

   private static int recursion(int n, int[] memo) {
      if (n < 0) {
         return 0;
      }
      if (memo[n] != 0) {
         return memo[n];
      }
      if (n == 0) {
         return 1;
      }

      memo[n] = recursion(n - 1, memo) + recursion(n - 2, memo);
      return memo[n];
   }
}