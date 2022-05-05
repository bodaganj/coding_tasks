package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

   public static void main(String[] args) {
      System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
      System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
   }

   private static int lengthOfLIS(int[] nums) {
      int[] dp = new int[nums.length];
      Arrays.fill(dp, 1);

      for (int i = 0; i < nums.length; i++) {
         for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
               dp[i] = Math.max(dp[i], dp[j] + 1);
            }
         }
      }

      int max = dp[0];
      for (int i = 1; i < dp.length; i++) {
         max = Math.max(max, dp[i]);
      }
      return max;
   }
}
