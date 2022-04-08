package com.coding.tasks.leetcode.first_round.google.arrays_and_strings;

public class MaximizeDistanceToClosestPerson {

   public static void main(String[] args) {
      System.out.println(maxDistToClosest(new int[]{1, 0, 1}));
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 1}));
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1}));
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 0, 1}));
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 0, 0, 1}));
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 0, 0, 0, 1}));
   }

   private static int maxDistToClosest(int[] seats) {
      int maxDistance = 0;
      int currentDistance = 0;
      int i = 0;
      boolean doWeHaveNeighborOnTheLeft = false;
      while (i < seats.length) {
         if (i == seats.length - 1 && seats[i] == 0) {
            currentDistance++;
            maxDistance = Math.max(maxDistance, currentDistance);
         }

         if (seats[i] == 0) {
            currentDistance++;
         } else {
            maxDistance = doWeHaveNeighborOnTheLeft ? Math.max(maxDistance, (currentDistance + 1) / 2) : currentDistance;
            currentDistance = 0;
            doWeHaveNeighborOnTheLeft = true;
         }
         i++;
      }

      return maxDistance;
   }
}
