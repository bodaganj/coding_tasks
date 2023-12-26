package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.dynamic.programming;

import java.util.Arrays;

public class CoinChange {

   public static void main(String[] args) {
//      System.out.println(coinChange(new int[]{1, 2, 5}, 11));
      System.out.println(coinChange(new int[]{2}, 3));
      System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
   }

   public static int coinChange(int[] coins, int amount) {
      if (amount == 0) {
         return 0;
      }
      Arrays.sort(coins);

      int[][] dp = new int[coins.length + 1][amount + 1];
      for (int i = 0; i < dp.length; i++) {
         for (int j = 1; j < dp[0].length; j++) {
            dp[i][j] = Integer.MAX_VALUE;
         }
      }

      for (int i = 1; i < dp.length; i++) {
         for (int j = 1; j < dp[0].length; j++) {
            if (j - coins[i - 1] >= 0) {
               if (dp[i][j - coins[i - 1]] == Integer.MAX_VALUE) {
                  dp[i][j] = dp[i - 1][j];
               } else {
                  dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
               }
            } else {
               dp[i][j] = dp[i - 1][j];
            }
            if (j % coins[i - 1] == 0) {
               dp[i][j] = Math.min(dp[i][j], j / coins[i - 1]);
            }
         }
      }

      return dp[coins.length][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
   }
}
