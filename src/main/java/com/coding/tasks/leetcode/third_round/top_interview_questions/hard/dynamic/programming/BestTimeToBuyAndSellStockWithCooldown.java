package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.dynamic.programming;

public class BestTimeToBuyAndSellStockWithCooldown {

   private static int max = 0;

   public static void main(String[] args) {
      System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2})); // 3
      System.out.println(maxProfit(new int[]{2, 4, 1, 7})); // 6
      System.out.println(maxProfit(new int[]{1, 4, 7, 5, 6, 2, 5, 1, 9, 7, 9, 7, 0, 6, 8})); // 22
   }

   public static int maxProfit(int[] prices) {
      max = 0;
      rec(0, prices, new int[prices.length]);
      return max;
   }

   private static int rec(int indexToBuy, int[] prices, int[] memo) {
      if (indexToBuy >= prices.length) {
         return 0;
      } else if (memo[indexToBuy] > 0) {
         return memo[indexToBuy];
      } else {
         int maxCurrentIndexProfit = 0;
         if (indexToBuy < prices.length - 1) {
            for (int buy = indexToBuy; buy < prices.length - 1; buy++) {
               int buyPrice = prices[buy];
               for (int i = buy + 1; i < prices.length; i++) {
                  if (prices[i] > buyPrice) {
                     int profit = prices[i] - buyPrice;
                     int profitSum = profit + rec(i + 2, prices, memo);
                     max = Math.max(max, profitSum);
                     maxCurrentIndexProfit = Math.max(maxCurrentIndexProfit, profitSum);
                  }
               }
            }
         }
         memo[indexToBuy] = maxCurrentIndexProfit;
         return memo[indexToBuy];
      }
   }
}
