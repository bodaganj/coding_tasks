package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.dynamic_programming;

import java.util.Arrays;

public class CoinChange {

   public static void main(String[] args) {
      System.out.println(coinChange(new int[]{2, 3, 6, 7}, 13));
      System.out.println(coinChange(new int[]{1, 2, 5}, 11));
      System.out.println(coinChange(new int[]{2}, 3));
      System.out.println(coinChange(new int[]{83, 186, 408, 419}, 6249));
   }

   private static int coinChange(int[] coins, int amount) {
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, amount + 1);
      dp[0] = 0;

      Arrays.sort(coins);
      for (int coin : coins) {
         for (int i = 1; i <= amount; i++) {
            if (i >= coin) {
               dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
         }
      }

      return dp[amount] > amount ? -1 : dp[amount];
   }
}
