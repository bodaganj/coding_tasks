package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.dynamic.programming;

public class MaximumSubarray {

   public int maxSubArray(int[] nums) {
      int max = nums[0];
      int prev = nums[0];
      for (int i = 1; i < nums.length; i++) {
         int currMax = Math.max(nums[i], prev + nums[i]);
         max = Math.max(max, currMax);
         prev = currMax;
      }
      return max;
   }
}
