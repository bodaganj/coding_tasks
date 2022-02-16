package com.coding.tasks.cracking.the.code.recursion_and_dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumHeightByStackingCuboids {

   private static int maxHeight;

   public static void main(String[] args) {
      System.out.println(maxHeight(new int[][]{{50, 45, 20}, {95, 37, 53}, {45, 23, 12}}));
   }

   private static int maxHeight(int[][] cuboids) {
      maxHeight = 0;

      for (int i = 0; i < cuboids.length; i++) {
         int currentMax = Integer.MIN_VALUE;
         for (int j = 0; j < cuboids[i].length; j++) {
            currentMax = Math.max(currentMax, cuboids[i][j]);
         }

         tryToAddCuboid(i, cuboids, new HashSet<>(), currentMax);
      }

      return maxHeight;
   }

   private static void tryToAddCuboid(int currentCuboidIndex, int[][] cuboids, Set<Integer> usedCuboids, int currentHeight) {
      maxHeight = Math.max(maxHeight, currentHeight);

      for (int i = 0; i < cuboids.length; i++) {
         if (i != currentCuboidIndex && !usedCuboids.contains(i)) {
            int[] currentCuboid = cuboids[currentCuboidIndex];
            int[] nextCuboid = cuboids[i];
            Arrays.sort(currentCuboid);
            Arrays.sort(nextCuboid);

            if (isCurrentCuboidLargerThenNext(currentCuboid, nextCuboid)) {
               usedCuboids.add(currentCuboidIndex);
               int newHeight = currentHeight + nextCuboid[nextCuboid.length - 1];

               tryToAddCuboid(i, cuboids, usedCuboids, newHeight);

               usedCuboids.remove(currentCuboidIndex);
            }
         }
      }
   }

   private static boolean isCurrentCuboidLargerThenNext(int[] currentCuboid, int[] nextCuboid) {
      for (int j = 0; j < currentCuboid.length; j++) {
         if (currentCuboid[j] < nextCuboid[j]) {
            return false;
         }
      }
      return true;
   }
}
