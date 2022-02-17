package com.coding.tasks.other;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

   public static void main(String[] args) {
      System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
   }

   private static int lengthOfLIS(int[] nums) {
      int[] dp = new int[nums.length];
      Arrays.fill(dp, 1);

      for (int i = 1; i < nums.length; i++) {
         for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
               dp[i] = Math.max(dp[i], dp[j] + 1);
            }
         }
      }

      return Arrays.stream(dp).max().getAsInt();
   }
}
