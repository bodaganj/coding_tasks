package com.coding.tasks.leetcode.google.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumAreaRectangle {

   public static void main(String[] args) {
      System.out.println(minAreaRect(new int[][]{
         {1, 1},
         {1, 3},
         {3, 1},
         {3, 3},
         {2, 2}
      }));

      System.out.println(minAreaRect(new int[][]{
         {1, 1},
         {1, 3},
         {3, 1},
         {3, 3},
         {4, 1},
         {4, 3}
      }));
   }

   private static int minAreaRect(int[][] points) {
      Map<Integer, Set<Integer>> hashmap = new HashMap<>();  // Key => Integer | Value => Set

      for (int[] point : points) {
         if (!hashmap.containsKey(point[0])) {
            hashmap.put(point[0], new HashSet<>());
         }
         hashmap.get(point[0]).add(point[1]);
      }

      int minArea = Integer.MAX_VALUE;

      for (int[] point : points) {  // Iterator corresponding to different A points
         for (int[] ints : points) { // Iterator corresponding to different B points

            int x1 = point[0], y1 = point[1];
            int x2 = ints[0], y2 = ints[1];

            // Point A & B must form a diagonal of the rectangle.
            if (x1 != x2 && y1 != y2) {
               // Check if D exists in hashmap and Check if C exists in hashmap
               if (hashmap.get(x1).contains(y2) && hashmap.get(x2).contains(y1)) {
                  minArea = Math.min(minArea, Math.abs(x1 - x2) * Math.abs(y1 - y2));
               }
            }
         }
      }
      return minArea != Integer.MAX_VALUE ? minArea : 0;
   }
}
