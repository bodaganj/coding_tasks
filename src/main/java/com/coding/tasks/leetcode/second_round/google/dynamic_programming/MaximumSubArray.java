package com.coding.tasks.leetcode.second_round.google.dynamic_programming;

public class MaximumSubArray {

   public static void main(String[] args) {
      System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
      System.out.println(maxSubArray(new int[]{1}));
      System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
   }

   private static int maxSubArray(int[] nums) {
      int max = Integer.MIN_VALUE;
      int prev = 0;
      for (int num : nums) {
         prev = Math.max(prev + num, num);
         max = Math.max(max, prev);
      }
      return max;
   }
}
