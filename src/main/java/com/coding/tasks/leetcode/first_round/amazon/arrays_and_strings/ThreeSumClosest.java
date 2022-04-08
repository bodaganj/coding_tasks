package com.coding.tasks.leetcode.first_round.amazon.arrays_and_strings;

import java.util.Objects;

public class ThreeSumClosest {

   public static void main(String[] args) {
      System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
      System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
   }

   // Can be done with O(n^2) !!!!!
   private static int threeSumClosest(int[] nums, int target) {
      int closest = 0;
      int difference = Integer.MAX_VALUE;

      if (!Objects.isNull(nums) && !(nums.length < 3)) {
         for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
               for (int z = j + 1; z < nums.length; z++) {
                  int current = nums[i] + nums[j] + nums[z];
                  if (Math.abs(target - current) < difference) {
                     closest = current;
                     difference = Math.abs(target - current);
                  }
               }
            }
         }
      }
      return closest;
   }
}
