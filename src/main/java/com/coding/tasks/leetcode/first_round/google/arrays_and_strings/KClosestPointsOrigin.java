package com.coding.tasks.leetcode.first_round.google.arrays_and_strings;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsOrigin {

   public static void main(String[] args) {
      System.out.println(Arrays.deepToString(kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
      System.out.println(Arrays.deepToString(kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
   }

   private static int[][] kClosest(int[][] points, int k) {
      PriorityQueue<Points> queue = new PriorityQueue<>();

      for (int[] point : points) {
         queue.add(new Points(point[0], point[1]));
         if (queue.size() > k) {
            queue.poll();
         }
      }

      int[][] res = new int[k][2];
      for (int i = 0; i < k; i++) {
         Points p = queue.poll();
         res[i] = new int[]{p.x, p.y};
      }

      return res;
   }

   static class Points implements Comparable<Points> {

      int x;
      int y;

      public Points(int x, int y) {
         this.x = x;
         this.y = y;
      }

      public double getDistance() {
         return Math.sqrt(x * x + y * y);
      }

      @Override
      public int compareTo(Points o) {
         return Double.compare(o.getDistance(), this.getDistance());
      }
   }
}
