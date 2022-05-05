package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.dynamic_programming;

public class JumpGame {

   public static void main(String[] args) {
      System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
      System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
      System.out.println(canJump(new int[]{2, 5, 0, 0}));
   }

   private static boolean canJump(int[] nums) {
      boolean[] dp = new boolean[nums.length];
      dp[dp.length - 1] = true;

      for (int i = dp.length - 2; i >= 0; i--) {
         for (int j = 1; j <= nums[i]; j++) {
            if (dp[i + j]) {
               dp[i] = true;
               break;
            }
         }
      }

      return dp[0];
   }
}
