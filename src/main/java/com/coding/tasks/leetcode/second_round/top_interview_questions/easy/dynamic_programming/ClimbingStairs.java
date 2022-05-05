package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.dynamic_programming;

public class ClimbingStairs {

   public static void main(String[] args) {
      System.out.println(climbStairs(3));
      System.out.println(climbStairs(2));
      System.out.println(climbStairs(7));
   }

   private static int climbStairs(int n) {
      if (n == 1) {
         return 1;
      }
      if (n == 2) {
         return 2;
      }

      int prevPrev = 1;
      int prev = 2;
      for (int i = 3; i <= n; i++) {
         int curr = prev + prevPrev;
         prevPrev = prev;
         prev = curr;
      }

      return prev;
   }
}