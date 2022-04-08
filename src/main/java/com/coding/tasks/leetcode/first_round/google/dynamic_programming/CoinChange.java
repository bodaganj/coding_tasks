package com.coding.tasks.leetcode.first_round.google.dynamic_programming;

import java.util.Arrays;

public class CoinChange {

   public static void main(String[] args) {
      System.out.println(coinChange(new int[]{1}, 0));
      System.out.println(coinChange(new int[]{2}, 3));
      System.out.println(coinChange(new int[]{1, 2, 5}, 11));
      System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
   }

   private static int coinChange(int[] coins, int amount) {
      if (amount == 0) {
         return 0;
      }
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, Integer.MAX_VALUE);
      Arrays.sort(coins);

      for (int coin : coins) {
         for (int i = 1; i < dp.length; i++) {
            if (i % coin == 0) {
               dp[i] = Math.min(dp[i], i / coin);
            } else if (coin < i && dp[i - coin] != Integer.MAX_VALUE) {
               dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
         }
      }

      return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
   }
}
