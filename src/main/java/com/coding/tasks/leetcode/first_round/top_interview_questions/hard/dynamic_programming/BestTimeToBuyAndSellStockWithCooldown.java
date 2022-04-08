package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.dynamic_programming;

public class BestTimeToBuyAndSellStockWithCooldown {

   private static int currentMaxProfit;

   public static void main(String[] args) {
      System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
      System.out.println(maxProfit(new int[]{2, 1, 4}));
      System.out.println(maxProfit(new int[]{1, 7, 2, 4}));
      System.out.println(maxProfit(new int[]{6, 1, 6, 4, 3, 0, 2}));
      System.out.println(maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
   }

   private static int maxProfit(int[] prices) {
      currentMaxProfit = 0;
      for (int i = 0; i < prices.length; i++) {
         rec(i, prices, 0);
      }
      return currentMaxProfit;
   }

   private static void rec(int indexToBuy, int[] prices, int currentProfit) {
      currentMaxProfit = Math.max(currentProfit, currentMaxProfit);

      for (int i = indexToBuy + 1; i < prices.length; i++) {
         int profit = prices[i] - prices[indexToBuy];
         if (profit > 0) {
            int updatedProfit = currentProfit + profit;
            currentMaxProfit = Math.max(updatedProfit, currentMaxProfit);
            for (int j = i + 2; j < prices.length; j++) {
               rec(j, prices, updatedProfit);
            }
         }
      }
   }
}
