package com.coding.tasks.leetcode.third_round.google.arrays.and.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostToHireKWorkers {

   public static void main(String[] args) {
      System.out.println(minCostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2)); // 105
//      System.out.println(minCostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3)); // 30.6
//      System.out.println(minCostToHireWorkers(new int[]{4, 5}, new int[]{8, 14}, 2)); // 25.2
   }

   // N * log N
   public static double minCostToHireWorkers(int[] quality, int[] wage, int k) {
      double[][] workers = new double[quality.length][2];
      for (int i = 0; i < quality.length; ++i) {
         workers[i] = new double[]{(double) (wage[i]) / quality[i], (double) quality[i]};
      }
      Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));
      double res = Double.MAX_VALUE, qsum = 0;
      PriorityQueue<Double> pq = new PriorityQueue<>();
      for (double[] worker : workers) {
         qsum += worker[1];
         pq.add(-worker[1]);
         if (pq.size() > k) {
            qsum += pq.poll();
         }
         if (pq.size() == k) {
            res = Math.min(res, qsum * worker[0]);
         }
      }
      return res;
   }

   // N^2 * log K
   public static double minCostToHireWorkers1(int[] quality, int[] wage, int k) {
      double min = Double.MAX_VALUE;

      for (int i = 0; i < quality.length; i++) {
         Queue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
         queue.add((double) wage[i]);

         int j = 0;
         while (j < quality.length) {
            if (j != i) {
               double potentialSalary = (double) wage[i] * quality[j] / quality[i];
               if (potentialSalary >= wage[j] && potentialSalary < min) {
                  queue.add(potentialSalary);
               }
               while (queue.size() > k) {
                  queue.poll();
               }
            }
            j++;
         }

         if (queue.size() == k) {
            double currentMin = 0;
            while (!queue.isEmpty()) {
               currentMin += queue.poll();
            }
            min = Math.min(min, currentMin);
         }
      }

      return min;
   }
}
