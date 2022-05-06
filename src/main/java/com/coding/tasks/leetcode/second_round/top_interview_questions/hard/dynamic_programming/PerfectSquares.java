package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.dynamic_programming;

import java.util.Arrays;

public class PerfectSquares {

   public static void main(String[] args) {
      System.out.println(numSquares(1));
      System.out.println(numSquares(13));
      System.out.println(numSquares(34));
      System.out.println(numSquares(32));
      System.out.println(numSquares(35));
   }

   private static int numSquares(int n) {
      int[] dp = new int[n + 1];
      Arrays.fill(dp, dp.length + 1);
      dp[0] = 0;

      int i = 1;
      while (i * i <= n) {
         int perfSquareNum = i * i;
         for (int j = 0; j < dp.length; j++) {
            if (j >= perfSquareNum) {
               dp[j] = Math.min(dp[j], 1 + dp[j - perfSquareNum]);
            }
         }
         i++;
      }

      return dp[n];
   }
}
