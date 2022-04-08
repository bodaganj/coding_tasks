package com.coding.tasks.leetcode.first_round.amazon.dynamic_programming;

public class MaximumSubarray {

   public static void main(String[] args) {
      System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
      System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
      System.out.println(maxSubArray(new int[]{1}));
   }

   private static int maxSubArray(int[] nums) {
      int max = nums[0];
      int currentMax = nums[0];

      for (int i = 1; i < nums.length; i++) {
         if (nums[i] > currentMax + nums[i]) {
            currentMax = nums[i];
         } else {
            currentMax += nums[i];
         }
         max = Math.max(max, currentMax);
      }

      return max;
   }
}
