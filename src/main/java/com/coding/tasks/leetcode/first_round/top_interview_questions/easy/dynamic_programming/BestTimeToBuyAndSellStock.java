package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.dynamic_programming;

public class BestTimeToBuyAndSellStock {

   public static void main(String[] args) {
      System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
   }

   private static int maxProfit(int[] prices) {
      if (prices == null || prices.length == 0) {
         return 0;
      }

      int min = prices[0];
      int bestSell = 0;
      for (int i = 1; i < prices.length; i++) {
         min = Math.min(min, prices[i]);
         bestSell = Math.max(bestSell, prices[i] - min);
      }

      return bestSell;
   }
}
