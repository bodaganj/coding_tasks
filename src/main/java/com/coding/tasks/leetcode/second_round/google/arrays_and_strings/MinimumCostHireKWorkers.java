package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.Arrays;

public class MinimumCostHireKWorkers {

   public static void main(String[] args) {
      System.out.println(mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
      System.out.println(mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
   }

   private static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
      double currentMin = Double.MAX_VALUE;

      double[] tmpWage = new double[wage.length];
      for (int i = 0; i < quality.length; i++) {
         for (int j = 0; j < quality.length; j++) {
            if (i == j) {
               tmpWage[j] = wage[i];
            } else {
               double potentialWage = (double) wage[i] * ((double) quality[j] / (double) quality[i]);
               if (potentialWage >= wage[j]) {
                  tmpWage[j] = potentialWage;
               } else {
                  tmpWage[j] = 1000000;
               }
            }
         }
         Arrays.sort(tmpWage);
         double min = 0;
         for (int l = 0; l < k; l++) {
            min += tmpWage[l];
         }
         currentMin = Math.min(currentMin, min);
      }
      return currentMin;
   }
}
