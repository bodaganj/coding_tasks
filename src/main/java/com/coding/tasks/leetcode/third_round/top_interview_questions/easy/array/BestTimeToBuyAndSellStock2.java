package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.array;

public class BestTimeToBuyAndSellStock2 {

   public static void main(String[] args) {
      System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
      System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
   }

   public static int maxProfit(int[] prices) {
      int buy = prices[0];
      int sum = 0;

      for (int i = 1; i < prices.length; i++) {
         int current = prices[i];

         if (current < buy) {
            buy = current;
         } else if (current > buy) {
            sum += current - buy;
            buy = current;
         }
      }

      return sum;
   }
}
