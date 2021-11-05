package com.coding.tasks.leetcode.google.dynamic_programming;

public class BestTimeToBuyAndSell {

   private static BestTimeToBuyAndSell sdf = new BestTimeToBuyAndSell();

   public static void main(String[] args) {
      System.out.println(sdf.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
      System.out.println(sdf.maxProfit(new int[]{7, 6, 4, 3, 1}));
      System.out.println(sdf.maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
   }

   public int maxProfit(int[] prices) {
      if (prices.length < 2) {
         return 0;
      }
      int lowest = prices[0];
      int max = Integer.MIN_VALUE;

      for (int i = 1; i < prices.length; i++) {
         lowest = Math.min(lowest, prices[i]);
         max = Math.max(max, prices[i] - lowest);
      }

      return Math.max(max, 0);
   }
}
