package com.coding.tasks.leetcode.third_round.fb.dynamic.programming;

public class ContinuousSubarraySum {

  public static void main(String[] args) {
    System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
  }

  public static boolean checkSubarraySum(int[] nums, int k) {
    int[][] dp = new int[nums.length][nums.length];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      dp[0][i] = sum;
      dp[i][i] = nums[i];
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = i + 1; j < dp[0].length; j++) {
        dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
      }
    }

    for (int i = 0; i < dp.length; i++) {
      for (int j = i + 1; j < dp[0].length; j++) {
        if (dp[i][j] % k == 0) {
          return true;
        }
      }
    }

    return false;
  }
}
