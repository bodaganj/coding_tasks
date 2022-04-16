package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostHireKWorkers {

   public static void main(String[] args) {
      System.out.println(mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
      System.out.println(mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
   }

   // TLE
//   private static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
//      double currentMin = Double.MAX_VALUE;
//      for (int i = 0; i < quality.length; i++) { // O(N)
//         Queue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());
//         for (int j = 0; j < quality.length; j++) { // O(N)
//            double potentialWage = (double) wage[i] * ((double) quality[j] / (double) quality[i]);
//            if (potentialWage >= wage[j]) { // O(logK)
//               queue.offer(potentialWage);
//            } else {
//               queue.offer(100000d);
//            }
//            while (queue.size() > k) {
//               queue.poll(); // O(logK)
//            }
//         }
//         double min = 0;
//         while (!queue.isEmpty()) {
//            min += queue.poll();
//         }
//         currentMin = Math.min(currentMin, min);
//      }
//      return currentMin;
//   }

   private static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
      Worker[] workers = new Worker[quality.length];
      for (int i = 0; i < quality.length; i++) {
         workers[i] = new Worker(quality[i], wage[i]);
      }
      Arrays.sort(workers); // Create array of workers (quality + ratio) and sort it

      double ans = Double.MAX_VALUE;
      Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
      int qualitySum = 0;

      for (Worker worker : workers) {
         queue.offer(worker.quality);

         /**
          * (THE CORE OF THE LOGIC) overall wage = overall quality * wage of the worker who will be earning his minimal wage
          * that is why workers are sorted according to ratio (if I have N ratio, then I can pay to worker with M ratio (M <= N), but not vise versa)
          */
         qualitySum += worker.quality;
         while (queue.size() > k) {
            qualitySum -= queue.poll();
         }
         if (queue.size() == k) {
            ans = Math.min(ans, qualitySum * worker.ratio());
         }
      }
      return ans;
   }

   static class Worker implements Comparable<Worker> {

      public int quality, wage;

      public Worker(int q, int w) {
         quality = q;
         wage = w;
      }

      public double ratio() {
         return (double) wage / quality;
      }

      public int compareTo(Worker other) {
         return Double.compare(ratio(), other.ratio());
      }
   }
}


