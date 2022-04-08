package com.coding.tasks.leetcode.first_round.amazon.dynamic_programming;

import java.util.Arrays;

public class CoinChange {

   public static void main(String[] args) {
      System.out.println(coinChange(new int[]{1, 2, 5}, 11));
      System.out.println(coinChange(new int[]{2}, 3));
      System.out.println(coinChange(new int[]{1}, 0));
   }

   private static int coinChange(int[] coins, int amount) {
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, amount + 1);
      dp[0] = 0;

      Arrays.sort(coins);
      for (int coin : coins) {
         for (int i = 1; i <= amount; i++) {
            if (i % coin == 0) {
               dp[i] = Math.min(dp[i], i / coin);
            } else if (i > coin) {
               dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
         }
      }

      return dp[amount] > amount ? -1 : dp[amount];
   }
}
