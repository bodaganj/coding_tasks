package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.dynamic_programming;

import java.util.Arrays;

public class CoinChange {

   public static void main(String[] args) {
      System.out.println(coinChange(new int[]{1, 2, 5}, 11));
      System.out.println(coinChange(new int[]{2}, 3));
      System.out.println(coinChange(new int[]{83, 186, 408, 419}, 6249));
   }

   private static int coinChange(int[] coins, int amount) {
      if (amount == 0) {
         return 0;
      }
      Arrays.sort(coins);
      int[][] dp = new int[coins.length + 1][amount + 1];

      for (int i = 1; i < dp.length; i++) {
         for (int j = 1; j < dp[0].length; j++) {
            if (j == coins[i - 1]) {
               dp[i][j] = 1;
            } else if (j > coins[i - 1]) {
               if (dp[i - 1][j] != 0 && dp[i][j - coins[i - 1]] != 0) {
                  dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
               } else if (dp[i][j - coins[i - 1]] != 0) {
                  dp[i][j] = 1 + dp[i][j - coins[i - 1]];
               } else {
                  dp[i][j] = dp[i - 1][j];
               }
            } else {
               dp[i][j] = dp[i - 1][j];
            }
         }
      }

      return dp[coins.length][amount] == 0 ? -1 : dp[coins.length][amount];
   }
}
