package com.coding.tasks.leetcode.first_round.google.arrays_and_strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostHireKWorkers {

   public static void main(String[] args) {
      System.out.println(mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
//      System.out.println(mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
   }

   // This will fail with RTL !!!!! But worth to know and understand
   // O(N^2 logN) and space O(n)
//   private static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
//      double ans = Double.MAX_VALUE;
//      int length = quality.length;
//
//      for (int i = 0; i < length; i++) {
//         double factor = (double) wage[i] / quality[i];
//
//         List<Double> prices = new ArrayList<>();
//         for (int j = 0; j < length; j++) {
//            double price = quality[j] * factor;
//            if (price >= wage[j]) {
//               prices.add(price);
//            }
//         }
//
//         if (prices.size() >= k) {
//            Collections.sort(prices);
//            ans = Math.min(ans, prices.stream().limit(k).mapToDouble(n -> n).sum());
//         }
//      }
//      return ans;
//   }

   // O(NlogK)
   private static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
      double[][] factorToQualityArray = new double[quality.length][2];
      for (int i = 0; i < quality.length; i++) {
         factorToQualityArray[i] = new double[]{(double) (wage[i]) / quality[i], (double) quality[i]};
      }
      Arrays.sort(factorToQualityArray, Comparator.comparingDouble(a -> a[0]));

      double res = Double.MAX_VALUE;
      double qsum = 0;
      PriorityQueue<Double> queue = new PriorityQueue<>();
      for (double[] worker : factorToQualityArray) {
         qsum += worker[1];
         queue.add(-worker[1]);
         if (queue.size() > k) {
            qsum += queue.poll();
         }
         if (queue.size() == k) {
            res = Math.min(res, qsum * worker[0]);
         }
      }
      return res;
   }
}
