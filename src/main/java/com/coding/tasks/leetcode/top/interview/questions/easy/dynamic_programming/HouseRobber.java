package com.coding.tasks.leetcode.top.interview.questions.easy.dynamic_programming;

import java.util.Arrays;

public class HouseRobber {

   public static void main(String[] args) {
      System.out.println(rob(new int[]{1, 2, 3, 1}));
      System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
      System.out.println(rob(new int[]{2, 1, 1, 2}));
      System.out.println(rob(new int[]{0}));
   }

   private static int rob(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }
      if (nums.length == 1) {
         return nums[0];
      }

      int[] dp = new int[nums.length];
      dp[0] = nums[0];
      dp[1] = nums[1];

      for (int i = 2; i < nums.length; i++) {
         for (int j = 0; j < i - 1; j++) {
            dp[i] = Math.max(dp[i], nums[i] + dp[j]);
         }
      }

      return Arrays.stream(dp).max().getAsInt();
   }
}
