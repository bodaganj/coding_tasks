package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.dynamic_programming;

public class BestTimeToBuyAndSellStock {

   public static void main(String[] args) {
      System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
   }

   private static int maxProfit(int[] prices) {
      int min = Integer.MAX_VALUE;
      int profit = 0;

      for (int price : prices) {
         if (price > min) {
            profit = Math.max(profit, price - min);
         } else {
            min = price;
         }
      }

      return profit;
   }
}
