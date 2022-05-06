package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.dynamic_programming;

public class MaximumProductSubarray {

   public static void main(String[] args) {
      System.out.println(maxProduct(new int[]{2, 3, -2, 4})); // 6
      System.out.println(maxProduct(new int[]{-2, 0, -1})); // 0
      System.out.println(maxProduct(new int[]{0, 2})); // 2
      System.out.println(maxProduct(new int[]{-2, 3, -4})); // 24
      System.out.println(maxProduct(new int[]{3, -1, 4})); // 4
      System.out.println(maxProduct(new int[]{2, -5, -2, -4, 3})); // 24
      System.out.println(maxProduct(new int[]{1, 0, -1, 2, 3, -5, -2})); // 60
      System.out.println(maxProduct(new int[]{1, -2, 3, -4, -3, -4, -3})); // 432
   }

   private static int maxProduct1(int[] nums) {
      int curMax = nums[0];
      int curMin = nums[0];
      int result = curMax;

      for (int i = 1; i < nums.length; i++) {
         int curr = nums[i];
         int tmpMax = Math.max(curr, Math.max(curMax * curr, curMin * curr));
         curMin = Math.min(curr, Math.min(curMax * curr, curMin * curr));
         curMax = tmpMax;
         result = Math.max(curMax, result);
      }

      return result;
   }

   private static int maxProduct(int[] nums) {
      int max = Integer.MIN_VALUE;

      int product = 1;
      for (int num : nums) {
         product *= num;
         max = Math.max(product, max);
         if (product == 0) {
            product = 1;
         }
      }

      product = 1;
      for (int i = nums.length - 1; i >= 0; i--) {
         product *= nums[i];
         max = Math.max(product, max);
         if (product == 0) {
            product = 1;
         }
      }

      return max;
   }
}
