package com.coding.tasks.leetcode.first_round.google.dynamic_programming;

public class BestTimeToBuyAndSell {

   public static void main(String[] args) {
      System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
      System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
      System.out.println(maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
   }

   private static int maxProfit(int[] prices) {
      int minPrice = prices[0];
      int profit = Integer.MIN_VALUE;

      for (int i = 1; i < prices.length; i++) {
         if (minPrice > prices[i]) {
            minPrice = prices[i];
         } else if (prices[i] - minPrice > profit) {
            profit = prices[i] - minPrice;
         }
      }

      return Math.max(profit, 0);
   }
}
