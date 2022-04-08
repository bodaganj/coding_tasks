package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.dynamic_programming;

public class MaximumSubarray {

   public static void main(String[] args) {
      System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
   }

   private static int maxSubArray(int[] nums) {
      int maxSum = nums[0];
      int currentMax = nums[0];

      for (int i = 1; i < nums.length; i++) {
         if (currentMax + nums[i] < nums[i]) {
            currentMax = nums[i];
         } else {
            currentMax += nums[i];
         }

         maxSum = Math.max(maxSum, currentMax);
      }

      return maxSum;
   }
}
