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
      rec(0, 0, prices);
      return max;
   }

   private static void rec(int indexToBuy, int currProfit, int[] prices) {
      if (indexToBuy < prices.length - 1) {
         for (int buy = indexToBuy; buy < prices.length - 1; buy++) {
            int buyPrice = prices[buy];
            for (int i = buy + 1; i < prices.length; i++) {
               if (prices[i] > buyPrice) {
                  int profit = prices[i] - buyPrice;
                  int profitSum = currProfit + profit;
                  max = Math.max(max, profitSum);
                  rec(i + 2, profitSum, prices);
               }
            }
         }
      }
   }
}
