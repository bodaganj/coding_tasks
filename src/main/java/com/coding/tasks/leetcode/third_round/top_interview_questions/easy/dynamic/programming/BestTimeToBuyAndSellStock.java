package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.dynamic.programming;

public class BestTimeToBuyAndSellStock {

  public static int maxProfit(int[] prices) {
    int buy = prices[0];
    int profit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < buy) {
        buy = prices[i];
      }
      profit = Math.max(profit, prices[i] - buy);
    }

    return profit;
  }
}
