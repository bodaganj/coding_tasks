package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.dynamic.programming;

public class BestTimeToBuyAndSellStock {

   public static int maxProfit(int[] prices) {
      int buy = Integer.MAX_VALUE;
      int profit = 0;

      for (int price : prices) {
         if (price < buy) {
            buy = price;
         } else if (price - buy > profit) {
            profit = price - buy;
         }
      }

      return profit;
   }
}
