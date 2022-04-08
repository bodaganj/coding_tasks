package com.coding.tasks.leetcode.first_round.amazon.sorting_and_searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

   public static void main(String[] args) {
//      System.out.println(Arrays.deepToString(kClosest(new int[][]{
//         {1, 3},
//         {5, -1}
//      }, 1)));

      System.out.println(Arrays.deepToString(kClosest(new int[][]{
         {3, 3},
         {-2, 4},
         {-2, 2}
      }, 2)));
   }

   private static int[][] kClosest(int[][] points, int k) {
      Map<Integer, Double> mapping = new HashMap<>();
      for (int i = 0; i < points.length; i++) {
         mapping.put(i, Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]));
      }

      Queue<Map.Entry<Integer, Double>> queue = new PriorityQueue<>((x, y) -> Double.compare(y.getValue(), x.getValue()));
      for (Map.Entry<Integer, Double> integerDoubleEntry : mapping.entrySet()) {
         queue.offer(integerDoubleEntry);
         if (queue.size() > k) {
            queue.poll();
         }
      }

      int[][] ans = new int[queue.size()][2];
      int i = 0;

      while (!queue.isEmpty()) {
         Map.Entry<Integer, Double> poll = queue.poll();
         ans[i][0] = points[poll.getKey()][0];
         ans[i][1] = points[poll.getKey()][1];
         i++;
      }

      return ans;
   }
}
