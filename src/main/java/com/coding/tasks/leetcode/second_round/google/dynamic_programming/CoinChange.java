package com.coding.tasks.leetcode.second_round.google.dynamic_programming;

import java.util.Arrays;

public class CoinChange {

   public static void main(String[] args) {
      System.out.println(coinChange(new int[]{1}, 0));
      System.out.println(coinChange(new int[]{2}, 3));
      System.out.println(coinChange(new int[]{1, 2, 5}, 11));
      System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
   }

   private static int coinChange(int[] coins, int amount) {
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, amount + 1);
      dp[0] = 0;

      for (int i = 1; i < dp.length; i++) {
         for (int coin : coins) {
            if (i >= coin) {
               dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
         }
      }

      return dp[amount] > amount ? -1 : dp[amount];
   }
}
