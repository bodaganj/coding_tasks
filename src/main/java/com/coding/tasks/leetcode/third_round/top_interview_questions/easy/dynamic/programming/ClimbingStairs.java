package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.dynamic.programming;

import java.util.Arrays;

public class ClimbingStairs {

   public static void main(String[] args) {
      System.out.println(climbStairs(5));
   }

   public static int climbStairs(int n) {
      int[] ints = new int[n + 1];
      Arrays.fill(ints, -1);
      return rec(n, ints);
   }

   public static int rec(int n, int[] memo) {
      if (n < 0) {
         return 0;
      }
      if (memo[n] >= 0) {
         return memo[n];
      }
      if (n == 0) {
         memo[n] = 1;
      }
      if (memo[n] < 0) {
         memo[n] = rec(n - 1, memo) + rec(n - 2, memo);
      }
      return memo[n];
   }

   public static int climbStairs1(int n) {
      int p0 = 0;
      int p1 = 1;
      while (n > 0) {
         n--;
         int tmp = p1 + p0;
         p0 = p1;
         p1 = tmp;
      }
      return p1;
   }
}
