package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.dynamic.programming;

public class MaximumProductSubarray {

   public static void main(String[] args) {
      System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
   }

   public static int maxProduct(int[] nums) {
      int max = nums[0];
      int curMin = nums[0];
      int curMax = nums[0];

      for (int i = 1; i < nums.length; i++) {
         int num = nums[i];
         int tmpMin = Math.min(num, Math.min(num * curMin, num * curMax));
         int tmpMax = Math.max(num, Math.max(num * curMin, num * curMax));
         curMin = tmpMin;
         curMax = tmpMax;
         max = Math.max(max, curMax);
      }

      return max;
   }
}
