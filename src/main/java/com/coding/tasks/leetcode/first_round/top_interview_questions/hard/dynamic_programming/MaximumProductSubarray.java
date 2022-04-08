package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.dynamic_programming;

public class MaximumProductSubarray {

   public static void main(String[] args) {
      System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
      System.out.println(maxProduct(new int[]{-2, 0, -1}));
      System.out.println(maxProduct(new int[]{0, 2}));
      System.out.println(maxProduct(new int[]{-2, 3, -4}));
      System.out.println(maxProduct(new int[]{3, -1, 4}));
      System.out.println(maxProduct(new int[]{2, -5, -2, -4, 3}));
   }

   private static int maxProduct(int[] nums) {
      int ans = Integer.MIN_VALUE;

      for (int i = 0; i < nums.length; i++) {
         ans = Math.max(ans, nums[i]);
         int current = 1;
         for (int j = i + 1; j < nums.length; j++) {
            current *= nums[j];
            ans = Math.max(ans, nums[i] * current);
         }
      }
      return ans;
   }
}
