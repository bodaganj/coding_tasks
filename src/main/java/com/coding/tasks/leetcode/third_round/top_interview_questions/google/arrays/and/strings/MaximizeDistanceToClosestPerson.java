package com.coding.tasks.leetcode.third_round.top_interview_questions.google.arrays.and.strings;

import java.util.Arrays;

public class MaximizeDistanceToClosestPerson {

   public static void main(String[] args) {
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1})); // 2
      System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0})); // 3
      System.out.println(maxDistToClosest(new int[]{1, 0})); // 1
      System.out.println(maxDistToClosest(new int[]{0, 1})); // 1
   }

   public static int maxDistToClosest(int[] seats) {
      int[] ans = new int[seats.length];
      Arrays.fill(ans, ans.length);
      int count = 1;
      int i = 0;
      while (seats[i] != 1) {
         i++;
      }
      while (i < seats.length) {
         if (seats[i] == 1) {
            ans[i] = 0;
            count = 1;
         } else {
            ans[i] = count;
            count++;
         }
         i++;
      }

      i = seats.length - 1;
      while (seats[i] != 1) {
         i--;
      }
      while (i >= 0) {
         if (seats[i] == 1) {
            ans[i] = 0;
            count = 1;
         } else {
            ans[i] = Math.min(ans[i], count);
            count++;
         }
         i--;
      }

      int max = 0;
      for (int an : ans) {
         max = Math.max(max, an);
      }

      return max;
   }
}
