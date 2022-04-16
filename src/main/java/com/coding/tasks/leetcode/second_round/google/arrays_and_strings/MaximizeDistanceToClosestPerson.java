package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

public class MaximizeDistanceToClosestPerson {

   public static void main(String[] args) {
      System.out.println(maxDistToClosest(new int[]{1, 0, 1}));
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 1}));
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1}));
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 0, 1}));
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 0, 0, 1}));
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 0, 0, 0, 1}));
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0}));
   }

   private static int maxDistToClosest(int[] seats) {
      int max = 0;
      int[] arr = new int[seats.length];

      int counter = 1000000;
      for (int i = 0; i < seats.length; i++) {
         if (seats[i] == 1) {
            counter = 0;
         } else {
            counter++;
         }
         arr[i] = counter;
      }

      counter = 1000000;
      for (int i = seats.length - 1; i >= 0; i--) {
         if (seats[i] == 1) {
            counter = 0;
         } else {
            counter++;
         }
         arr[i] = Math.min(arr[i], counter);
         max = Math.max(max, arr[i]);
      }

      return max;
   }
}
