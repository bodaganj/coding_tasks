package com.coding.tasks.leetcode.second_round.amazon.sorting_and_searching;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

   public static void main(String[] args) {
      System.out.println(Arrays.deepToString(kClosest(new int[][]{
         {1, 3},
         {5, -1}
      }, 1)));

      System.out.println(Arrays.deepToString(kClosest(new int[][]{
         {3, 3},
         {-2, 4},
         {-2, 2}
      }, 2)));
   }

   private static int[][] kClosest(int[][] points, int k) {
      Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
         int tmp1 = o1[0] * o1[0] + o1[1] * o1[1];
         int tmp2 = o2[0] * o2[0] + o2[1] * o2[1];
         return Integer.compare(tmp2, tmp1);
      });

      for (int[] point : points) {
         queue.offer(point);
         if (queue.size() > k) {
            queue.poll();
         }
      }

      int[][] ans = new int[queue.size()][2];
      int i = 0;
      while (!queue.isEmpty()) {
         ans[i] = queue.poll();
         i++;
      }
      return ans;
   }
}
