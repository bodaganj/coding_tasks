package com.coding.tasks.other;

/**
 * See knapsack_problem.png to understand the task
 */
public class KnapsackProblem {

   public static void main(String[] args) {
      System.out.println(insertItemWithMaxTotalPrice(new int[]{1, 8, 18, 22, 28},
                                                     new int[]{1, 3, 5, 6, 7},
                                                     11));
      System.out.println(insertItemWithMaxTotalPrice(new int[]{4, 2, 3},
                                                     new int[]{1, 2, 3},
                                                     4));
   }

   // O(n*weightLimit)
   private static int insertItemWithMaxTotalPrice(int[] prices, int[] weights, int weightLimit) {
      int length = prices.length;
      if (length <= 0 || weightLimit <= 0) {
         return 0;
      }

      int[][] table = new int[length + 1][weightLimit + 1];
      for (int j = 0; j <= weightLimit; j++) {
         table[0][j] = 0;
      }

      for (int i = 1; i <= length; i++) {
         for (int j = 1; j <= weightLimit; j++) {
            if (weights[i - 1] > j) {
               table[i][j] = table[i - 1][j];
            } else {
               table[i][j] = Math.max(
                  table[i - 1][j],
                  table[i - 1][j - weights[i - 1]] + prices[i - 1]);
            }
         }
      }
      return table[length][weightLimit];
   }
}
