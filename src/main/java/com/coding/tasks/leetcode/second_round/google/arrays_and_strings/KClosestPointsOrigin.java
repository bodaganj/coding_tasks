package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsOrigin {

   public static void main(String[] args) {
      System.out.println(Arrays.deepToString(kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
      System.out.println(Arrays.deepToString(kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
   }

   private static int[][] kClosest(int[][] points, int k) {
      Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> Double.compare(Math.sqrt(Math.pow(o2[0], 2) + Math.pow(o2[1], 2)),
                                                                          Math.sqrt(Math.pow(o1[0], 2) + Math.pow(o1[1], 2))));
      for (int[] point : points) {
         queue.offer(point);
         while (queue.size() > k) {
            queue.poll();
         }
      }

      int[][] ans = new int[k][2];
      int counter = 0;
      while (!queue.isEmpty()) {
         ans[counter] = queue.poll();
         counter++;
      }
      return ans;
   }
}
