package com.coding.tasks.leetcode.third_round.fb.dynamic.programming;

public class ContinuousSubarraySum {

  public static void main(String[] args) {
    System.out.println(checkSubarraySum(new int[]{23, 2, 6, 2, 5}, 6));
//    System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
//    System.out.println(checkSubarraySum(new int[]{1, 0}, 2));
  }

  public static boolean checkSubarraySum(int[] nums, int k) {
    int[] dp = new int[nums.length];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (i > 0 && sum % k == 0) {
        return true;
      }
      dp[i] = sum;
    }


    int index = 1;
    while (index < dp.length) {
      int prev = 0;
      for (int i = index ; i < dp.length; i++) {
        int curr;
        if (i == index) {
          curr = nums[i];
        } else {
          curr = prev + dp[i] - dp[i - 1];
        }
        if (i > index && curr % k == 0) {
          return true;
        }
        dp[i - 1] = prev;
        prev = curr;
        if (i == dp.length - 1) {
          dp[i] = curr;
        }
      }
      index++;
    }

    return false;
  }
}
