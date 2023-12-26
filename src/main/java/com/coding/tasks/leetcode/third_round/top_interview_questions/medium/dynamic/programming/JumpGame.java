package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.dynamic.programming;

public class JumpGame {

   public boolean canJump(int[] nums) {
      if (nums.length == 1) {
         return true;
      }
      int lastTrue = nums.length - 1;
      int i = nums.length - 2;
      while (i >= 0) {
         if (nums[i] + i >= lastTrue) {
            lastTrue = i;
         }
         i--;
      }
      return lastTrue == 0;
   }
}
