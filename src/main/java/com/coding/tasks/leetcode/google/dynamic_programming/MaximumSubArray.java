package com.coding.tasks.leetcode.google.dynamic_programming;

public class MaximumSubArray {

   private static MaximumSubArray maximumSubArray = new MaximumSubArray();

   public static void main(String[] args) {
      System.out.println(maximumSubArray.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
      System.out.println(maximumSubArray.maxSubArray(new int[] {1}));
      System.out.println(maximumSubArray.maxSubArray(new int[] {5,4,-1,7,8}));
   }

   public int maxSubArray(int[] nums) {
      int currentMax = nums[0];
      int max = nums[0];

      for (int i = 1; i < nums.length; i++) {
         int current = nums[i];
         currentMax = Math.max(current, currentMax + current);
         max = Math.max(max, currentMax);
      }
      return max;
   }
}
