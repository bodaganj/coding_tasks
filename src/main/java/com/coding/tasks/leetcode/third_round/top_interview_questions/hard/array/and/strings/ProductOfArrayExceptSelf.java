package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.array.and.strings;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
   }

   public static int[] productExceptSelf(int[] nums) {
      int[] ans = new int[nums.length];
      ans[0] = 1;
      for (int i = 1; i < ans.length; i++) {
         ans[i] = ans[i - 1] * nums[i - 1];
      }

      int prev = 1;
      for (int i = ans.length - 2; i >= 0; i--) {
         ans[i] = nums[i + 1] * prev * ans[i];
         prev *= nums[i + 1];
      }

      return ans;
   }
}
