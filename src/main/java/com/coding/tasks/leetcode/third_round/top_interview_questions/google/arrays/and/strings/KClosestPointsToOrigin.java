package com.coding.tasks.leetcode.third_round.top_interview_questions.google.arrays.and.strings;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

   public static void main(String[] args) {

   }

   private static int[][] kClosest(int[][] points, int k) {
      Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingDouble(Pair::distance).reversed());
      for (int i = 0; i < points.length; i++) {
         int[] point = points[i];
         queue.add(new Pair(Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2)), i));
         while (queue.size() > k) {
            queue.poll();
         }
      }
      int[][] ans = new int[k][2];
      int i = 0;
      while (!queue.isEmpty()) {
         ans[i] = points[queue.poll().index];
         i++;
      }
      return ans;
   }

   private record Pair(double distance, int index) {

   }
}
