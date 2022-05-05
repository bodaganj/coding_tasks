package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.dynamic_programming;

public class MaximumSubarray {

   public static void main(String[] args) {
      System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
   }

   private static int maxSubArray(int[] nums) {
      int[] dp = new int[nums.length];
      dp[0] = nums[0];

      for (int i = 1; i < nums.length; i++) {
         dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
      }

      int max = dp[0];
      for (int i = 1; i < dp.length; i++) {
         max = Math.max(max, dp[i]);
      }

      return max;
   }
}
