package com.coding.tasks.leetcode.google.arrays_and_strings;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostHireKWorkers {

   public static void main(String[] args) {
      System.out.println(mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
      System.out.println(mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
   }

   private static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
      int N = quality.length;
      Worker[] workers = new Worker[N];
      for (int i = 0; i < N; ++i) {
         workers[i] = new Worker(quality[i], wage[i]);
      }
      Arrays.sort(workers);

      double ans = 1e9;
      int sumq = 0;
      PriorityQueue<Integer> pool = new PriorityQueue<>();
      for (Worker worker : workers) {
         pool.offer(-worker.quality);
         sumq += worker.quality;
         if (pool.size() > k) {
            sumq += pool.poll();
         }
         if (pool.size() == k) {
            ans = Math.min(ans, sumq * worker.ratio());
         }
      }

      return ans;
   }
}

class Worker implements Comparable<Worker> {

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
