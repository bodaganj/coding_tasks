package com.coding.tasks.leetcode.first_round.google.arrays_and_strings;

import java.util.Arrays;

public class MaxDistanceToClosestPerson {

   public static void main(String[] args) {
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0}));
      System.out.println(maxDistToClosest(new int[]{0, 1}));
   }

   private static int maxDistToClosest(int[] seats) {
      int length = seats.length;
      int[] left = new int[length], right = new int[length];
      Arrays.fill(left, length);
      Arrays.fill(right, length);

      for (int i = 0; i < length; ++i) {
         if (seats[i] == 1) {
            left[i] = 0;
         } else if (i > 0) {
            left[i] = left[i - 1] + 1;
         }
      }

      for (int i = length - 1; i >= 0; --i) {
         if (seats[i] == 1) {
            right[i] = 0;
         } else if (i < length - 1) {
            right[i] = right[i + 1] + 1;
         }
      }

      int ans = 0;
      for (int i = 0; i < length; ++i) {
         if (seats[i] == 0) {
            ans = Math.max(ans, Math.min(left[i], right[i]));
         }
      }
      return ans;
   }
}
