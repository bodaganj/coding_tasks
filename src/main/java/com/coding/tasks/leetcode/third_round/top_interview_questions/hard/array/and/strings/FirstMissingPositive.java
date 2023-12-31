package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.array.and.strings;

public class FirstMissingPositive {

   public int firstMissingPositive(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] < 1 || nums[i] == 0) {
            nums[i] = nums.length + 1;
         }
      }

      for (int i = 0; i < nums.length; i++) {
         int currentValue = Math.abs(nums[i]);
         if (currentValue < nums.length) {
            if (nums[currentValue] > 0) {
               nums[currentValue] *= -1;
            }
         }
         if (currentValue == nums.length) {
            nums[0] = -nums.length;
         }
      }

      for (int i = 1; i < nums.length; i++) {
         if (nums[i] > 0) {
            return i;
         }
      }
      if (nums[0] > 0) {
         return nums.length;
      }

      return nums.length + 1;
   }
}
