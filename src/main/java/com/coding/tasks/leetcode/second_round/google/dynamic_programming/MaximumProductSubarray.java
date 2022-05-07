package com.coding.tasks.leetcode.second_round.google.dynamic_programming;

public class MaximumProductSubarray {

   public static void main(String[] args) {
      System.out.println(maxProduct(new int[]{2, 3, -2, 4})); // 6
      System.out.println(maxProduct(new int[]{-2, 0, -1})); // 0
      System.out.println(maxProduct(new int[]{-2})); // -2
      System.out.println(maxProduct(new int[]{3, -1, 4})); // 4
      System.out.println(maxProduct(new int[]{2, -5, -2, -4, 3})); // 24
   }

   private static int maxProduct(int[] nums) {
      int max = nums[0];
      int currentMax = nums[0];
      int currentMin = nums[0];

      for (int i = 1; i < nums.length; i++) {
         int num = nums[i];

         int tmpMax = currentMax * num;
         int tmpMin = currentMin * num;

         if (tmpMax > tmpMin) {
            currentMax = Math.max(tmpMax, num);
            currentMin = Math.min(tmpMin, num);
         } else {
            currentMax = Math.max(tmpMin, num);
            currentMin = Math.min(tmpMax, num);
         }

         max = Math.max(max, currentMax);
      }

      return max;
   }

   private static int maxProduct1(int[] nums) {
      int max = Integer.MIN_VALUE;

      int prev = 1;
      for (int num : nums) {
         prev *= num;
         max = Math.max(max, prev);
         if (prev == 0) {
            prev = 1;
         }
      }

      prev = 1;
      for (int i = nums.length - 1; i >= 0; i--) {
         prev *= nums[i];
         max = Math.max(max, prev);
         if (prev == 0) {
            prev = 1;
         }
      }

      return max;
   }
}
