package com.coding.tasks.leetcode.first_round.google.dynamic_programming;

import java.util.Arrays;

public class MaximumProductSubarray {

   public static void main(String[] args) {
      System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
      System.out.println(maxProduct(new int[]{-2, 0, -1}));
      System.out.println(maxProduct(new int[]{-2}));
      System.out.println(maxProduct(new int[]{3, -1, 4}));
      System.out.println(maxProduct(new int[]{2, -5, -2, -4, 3}));
   }

   private static int maxProduct(int[] nums) {
      int maxLeft = nums[0];
      int[] dp = new int[nums.length];
      dp[0] = nums[0];

      for (int i = 1; i < nums.length; i++) {
         if (dp[i - 1] == 0) {
            dp[i] = nums[i];
         } else {
            dp[i] = dp[i - 1] * nums[i];
         }
         maxLeft = Math.max(maxLeft, dp[i]);
      }

      int maxRight = nums[nums.length - 1];
      Arrays.fill(dp, 0);
      dp[nums.length - 1] = nums[dp.length - 1];

      for (int i = dp.length - 2; i >= 0; i--) {
         if (dp[i + 1] == 0) {
            dp[i] = nums[i];
         } else {
            dp[i] = dp[i + 1] * nums[i];
         }
         maxRight = Math.max(maxRight, dp[i]);
      }

      return Math.max(maxLeft, maxRight);
   }
}
