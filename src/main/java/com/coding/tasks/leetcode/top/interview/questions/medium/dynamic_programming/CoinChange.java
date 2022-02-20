package com.coding.tasks.leetcode.top.interview.questions.medium.dynamic_programming;

import java.util.Arrays;

public class CoinChange {

//   private static int min = Integer.MAX_VALUE;

   public static void main(String[] args) {
      System.out.println(coinChange(new int[]{1, 2, 5}, 11));
      System.out.println(coinChange(new int[]{2}, 3));
      System.out.println(coinChange(new int[]{83, 186, 408, 419}, 6249));
   }

   /**
    * Wow!!!
    */
   private static int coinChange(int[] coins, int amount) {
      int max = amount + 1;
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, max);
      dp[0] = 0;
      for (int i = 1; i <= amount; i++) {
         for (int coin : coins) {
            if (coin <= i) {
               dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
         }
      }
      return dp[amount] > amount ? -1 : dp[amount];
   }

//   private static int coinChange(int[] coins, int amount) {
//      if (amount == 0) {
//         return 0;
//      }
//
//      Arrays.sort(coins);
//
//      int[][] dp = new int[coins.length][amount + 1];
//      for (int[] ints : dp) {
//         Arrays.fill(ints, -1);
//      }
//
//      for (int i = 0; i < dp.length; i++) {
//         for (int j = 1; j < dp[0].length; j++) {
//            if (coins[i] == j) {
//               dp[i][j] = 1;
//            } else if (i > 0 && coins[i] > j) {
//               dp[i][j] = dp[i - 1][j];
//            } else {
//               int potentialIndex = j - coins[i];
//               if (potentialIndex > 0 && dp[i][potentialIndex] != -1) {
//                  dp[i][j] = dp[i][potentialIndex] + 1;
//               }
//            }
//         }
//      }
//
//      return dp[dp.length - 1][dp[0].length - 1];
//   }

//   private static int coinChange1(int[] coins, int amount) {
//      if (amount == 0) {
//         return 0;
//      }
//
//      min = Integer.MAX_VALUE;
//      Arrays.sort(coins);
//      dfs(coins, amount, 0);
//      return min == Integer.MAX_VALUE ? -1 : min;
//   }
//
//   private static void dfs(int[] coins, int amount, int stepsCount) {
//      if (min < Integer.MAX_VALUE) {
//         return;
//      }
//      if (amount == 0) {
//         min = stepsCount;
//      } else if (amount > 0) {
//         for (int i = coins.length - 1; i >= 0; i--) {
//            dfs(coins, amount - coins[i], stepsCount + 1);
//         }
//      }
//   }

//   private static int coinChange(int[] coins, int amount) {
//      if (amount == 0) {
//         return 0;
//      }
//
//      min = Integer.MAX_VALUE;
//
//      dfs(coins, amount, 0);
//      return min == Integer.MAX_VALUE ? -1 : min;
//   }
//
//   private static void dfs(int[] coins, int amount, int stepsCount) {
//      if (amount == 0) {
//         min = Math.min(min, stepsCount);
//      } else if (amount > 0) {
//         for (int coin : coins) {
//            dfs(coins, amount - coin, stepsCount + 1);
//         }
//      }
//   }
}
