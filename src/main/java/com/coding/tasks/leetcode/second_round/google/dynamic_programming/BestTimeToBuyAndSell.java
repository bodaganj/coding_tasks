package com.coding.tasks.leetcode.second_round.google.dynamic_programming;

public class BestTimeToBuyAndSell {

   public static void main(String[] args) {
      System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
      System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
      System.out.println(maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
   }

   private static int maxProfit(int[] prices) {
      if (prices.length == 1) {
         return 0;
      }

      int profit = 0;
      int buy = prices[0];
      for (int i = 1; i < prices.length; i++) {
         if (prices[i] > buy) {
            profit = Math.max(profit, prices[i] - buy);
         } else {
            buy = prices[i];
         }
      }
      return profit;
   }
}
