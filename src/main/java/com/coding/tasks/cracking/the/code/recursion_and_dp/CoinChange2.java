package com.coding.tasks.cracking.the.code.recursion_and_dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CoinChange2 {

   private static Set<Map<Integer, Integer>> set;

   public static void main(String[] args) {
      System.out.println(changeRec(5, new int[]{1, 2, 5}));
      System.out.println(changeRec(10, new int[]{2, 5}));
      System.out.println("azaza");
      System.out.println(change(5, new int[]{1, 2, 5}));
      System.out.println(change(10, new int[]{2, 5}));
   }

   /**
    * DP
    */
   private static int change(int amount, int[] coins) {
      int rows = coins.length + 1;
      int cols = amount + 1;

      int[][] matrix = new int[rows][cols];
      for (int i = 0; i < rows; i++) {
         matrix[i][0] = 1;
      }

      for (int i = 1; i < rows; i++) {
         for (int j = 1; j < cols; j++) {
            int coin = coins[i - 1];
            if (coin <= j) {
               matrix[i][j] = matrix[i - 1][j] + matrix[i][j - coin];
            } else {
               matrix[i][j] = matrix[i - 1][j];
            }
         }
      }

      return matrix[rows - 1][cols - 1];
   }

   /**
    * recursion (TLE!!!)
    */
   private static int changeRec(int amount, int[] coins) {
      set = new HashSet<>();
      rec(amount, coins, new HashMap<>());
      return set.size();
   }

   private static void rec(int amount, int[] coins, Map<Integer, Integer> map) {
      if (amount == 0) {
         set.add(map);
      } else if (amount < 0) {
         return;
      }

      for (int coin : coins) {
         Map<Integer, Integer> tmp = new HashMap<>(map);
         tmp.put(coin, tmp.getOrDefault(coin, 0) + 1);
         rec(amount - coin, coins, tmp);
      }
   }
}
