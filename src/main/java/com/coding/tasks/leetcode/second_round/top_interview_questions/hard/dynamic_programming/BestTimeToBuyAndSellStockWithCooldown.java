package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.dynamic_programming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {

   public static void main(String[] args) {
      System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
      System.out.println(maxProfit(new int[]{2, 1, 4}));
      System.out.println(maxProfit(new int[]{1, 7, 2, 4}));
      System.out.println(maxProfit(new int[]{6, 1, 6, 4, 3, 0, 2}));
      System.out.println(maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
   }

   private static int maxProfit(int[] prices) {
      int length = prices.length;

      if (length < 2) {
         return 0;
      }

      int[] dp = new int[length];
      dp[0] = 0;
      for (int i = 1; i < length; i++) {

      }

      return Arrays.stream(dp).max().getAsInt();
   }
}
