package com.coding.tasks.leetcode.second_round.google.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumAreaRectangle {

   public static void main(String[] args) {
//      System.out.println(minAreaRect(new int[][]{
//         {1, 1},
//         {1, 3},
//         {3, 1},
//         {3, 3},
//         {2, 2}
//      }));

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
      Set<List<Integer>> set = new HashSet<>();
      for (int[] point : points) {
         set.add(List.of(point[0], point[1]));
      }

      int min = Integer.MAX_VALUE;
      for (int[] point : points) {
         List<int[]> pointsOnTheSameRow = getPointsOnTheSameRow(point, points);
         List<int[]> pointsOnTheSameCol = getPointsOnTheSameCol(point, points);

         for (int[] col : pointsOnTheSameCol) {
            for (int[] row : pointsOnTheSameRow) {
               if (set.contains(List.of(row[0], col[1]))) {
                  min = Math.min(min, Math.abs(col[1] - point[1]) * Math.abs((row[0] - point[0])));
               }
            }
         }
      }

      return min == Integer.MAX_VALUE ? 0 : min;
   }

   private static List<int[]> getPointsOnTheSameRow(int[] point, int[][] points) {
      List<int[]> ans = new ArrayList<>();
      for (int[] ints : points) {
         if (point[0] != ints[0] && point[1] == ints[1]) {
            ans.add(ints);
         }
      }
      return ans;
   }

   private static List<int[]> getPointsOnTheSameCol(int[] point, int[][] points) {
      List<int[]> ans = new ArrayList<>();
      for (int[] ints : points) {
         if (point[0] == ints[0] && point[1] != ints[1]) {
            ans.add(ints);
         }
      }
      return ans;
   }
}
