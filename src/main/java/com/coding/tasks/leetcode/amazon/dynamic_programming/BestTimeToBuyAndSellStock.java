package com.coding.tasks.leetcode.amazon.dynamic_programming;

public class BestTimeToBuyAndSellStock {

   public static void main(String[] args) {
      System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
      System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
      System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
   }

   private static int maxProfit(int[] prices) {
      int buy = prices[0];
      int sell = Integer.MIN_VALUE;
      int profit = 0;

      for (int i = 1; i < prices.length; i++) {
         if (prices[i] < buy) {
            buy = prices[i];
            sell = Integer.MIN_VALUE;
         } else if (prices[i] > sell) {
            sell = prices[i];
            profit = Math.max(profit, sell - buy);
         }
      }

      return profit;
   }
}
