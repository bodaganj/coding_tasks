package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.dynamic_programming;

public class HouseRobber {

   public static void main(String[] args) {
      System.out.println(rob(new int[]{1, 2, 3, 1}));
      System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
      System.out.println(rob(new int[]{2, 1, 1, 2}));
      System.out.println(rob(new int[]{0}));
   }

   private static int rob(int[] nums) {
      if (nums.length == 1) {
         return nums[0];
      }

      int fMax = nums[0];
      for (int i = 2; i < nums.length; i++) {
         int tmp = fMax + nums[i];
         nums[i] = tmp;
         fMax = Math.max(fMax, nums[i - 1]);
      }

      int max = nums[0];
      for (int i = 1; i < nums.length; i++) {
         max = Math.max(max, nums[i]);
      }
      return max;
   }
}
