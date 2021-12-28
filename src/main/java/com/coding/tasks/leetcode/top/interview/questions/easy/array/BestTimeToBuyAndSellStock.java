package com.coding.tasks.leetcode.top.interview.questions.easy.array;

public class BestTimeToBuyAndSellStock {

   public static void main(String[] args) {
      System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
      System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
      System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
      System.out.println(maxProfit(new int[]{1, 2}));
      System.out.println(maxProfit(new int[]{1, 7, 2, 3, 6, 7, 6, 7}));
   }

   /**
    * best case!!!!!
    */
//   private static int maxProfit(int[] prices) {
//      int maxprofit = 0;
//      for (int i = 1; i < prices.length; i++) {
//         if (prices[i] > prices[i - 1])
//            maxprofit += prices[i] - prices[i - 1];
//      }
//      return maxprofit;
//   }

   private static int maxProfit(int[] prices) {
      int result = 0;
      int currentBuy = Integer.MAX_VALUE;
      int currentSell = Integer.MIN_VALUE;
      boolean doWeNeedToBuy = true;

      for (int i = 0; i < prices.length; i++) {
         int price = prices[i];

         if (doWeNeedToBuy) {
            if (price <= currentBuy) {
               currentBuy = price;
            } else {
               currentSell = price;
               doWeNeedToBuy = false;
               if (i == prices.length - 1) {
                  result += currentSell - currentBuy;
               }
            }
         } else {
            if (price < currentSell) {
               result += currentSell - currentBuy;
               currentBuy = price;
               doWeNeedToBuy = true;
            } else {
               currentSell = price;
               if (i == prices.length - 1) {
                  result += currentSell - currentBuy;
               }
            }
         }
      }

      return result;
   }
}
