package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.dynamic.programming;

import java.util.Arrays;

public class HouseRobber {

   public static void main(String[] args) {
      System.out.println(rob(new int[]{1, 2, 3, 1}));
      System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
      System.out.println(rob(new int[]{2, 1, 1, 2}));
      System.out.println(rob(new int[]{0}));
   }

   public static int rob(int[] nums) {
      if (nums.length == 1) {
         return nums[0];
      }
      int[] max = Arrays.copyOf(nums, nums.length);
      max[1] = Math.max(max[0], max[1]);
      for (int i = 2; i < nums.length; i++) {
         max[i] = Math.max(max[i - 1], max[i - 2] + nums[i]);
      }

      return max[nums.length - 1];
   }
}
