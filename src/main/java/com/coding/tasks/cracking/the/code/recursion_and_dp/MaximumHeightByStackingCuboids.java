package com.coding.tasks.cracking.the.code.recursion_and_dp;

import java.util.Arrays;

public class MaximumHeightByStackingCuboids {

//   private static int maxHeight;

   public static void main(String[] args) {
      System.out.println(maxHeight(new int[][]{{50, 45, 20}, {95, 37, 53}, {45, 23, 12}}));
   }

   private static int maxHeight(int[][] cuboids) {
      for (int[] a : cuboids) {
         Arrays.sort(a);
      }

      // reverse order
      Arrays.sort(cuboids, (a, b) -> {
         if (a[0] != b[0]) {
            return b[0] - a[0];
         }
         if (a[1] != b[1]) {
            return b[1] - a[1];
         }
         return b[2] - a[2];
      });

      int length = cuboids.length;
      int res = 0;
      int[] dp = new int[length];

      for (int j = 0; j < length; ++j) {
         dp[j] = cuboids[j][2];

         for (int i = 0; i < j; ++i) {
            if (cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2]) {
               dp[j] = Math.max(dp[j], dp[i] + cuboids[j][2]);
            }
         }
         res = Math.max(res, dp[j]);
      }
      return res;
   }

//   private static int maxHeight(int[][] cuboids) {
//      maxHeight = 0;
//
//      for (int[] cuboid : cuboids) {
//         Arrays.sort(cuboid);
//      }
//      Arrays.sort(cuboids, Comparator.<int[]>comparingInt(cuboid -> cuboid[2])
//                                     .thenComparingInt(cuboid -> cuboid[1])
//                                     .thenComparingInt(cuboid -> cuboid[0]));
//
//      for (int i = cuboids.length - 1; i >= 0; i--) {
//         tryToAddCuboid(i, cuboids, new HashSet<>(), cuboids[i][2]);
//      }
//
//      return maxHeight;
//   }
//
//   private static void tryToAddCuboid(int currentCuboidIndex, int[][] cuboids, Set<Integer> usedCuboids, int currentHeight) {
//      maxHeight = Math.max(maxHeight, currentHeight);
//
//      for (int i = currentCuboidIndex - 1; i >= 0; i--) {
//         if (!usedCuboids.contains(i)) {
//            int[] currentCuboid = cuboids[currentCuboidIndex];
//            int[] nextCuboid = cuboids[i];
//
//            if (isCurrentCuboidLargerThenNext(currentCuboid, nextCuboid)) {
//               usedCuboids.add(currentCuboidIndex);
//               int newHeight = currentHeight + nextCuboid[2];
//
//               tryToAddCuboid(i, cuboids, usedCuboids, newHeight);
//
//               usedCuboids.remove(currentCuboidIndex);
//            }
//         }
//      }
//   }
//
//   private static boolean isCurrentCuboidLargerThenNext(int[] currentCuboid, int[] nextCuboid) {
//      for (int j = 0; j < currentCuboid.length; j++) {
//         if (currentCuboid[j] < nextCuboid[j]) {
//            return false;
//         }
//      }
//      return true;
//   }
}
