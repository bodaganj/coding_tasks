package com.coding.tasks.leetcode.third_round.fb.arrays.and.strings;

public class SubarraySumEqualsK {

   public static void main(String[] args) {
      System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
      System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));
   }

   public static int subarraySum(int[] nums, int k) {
      int count = 0;
      for (int i = 0; i < nums.length; i++) {
         int currSum = 0;
         for (int j = i; j < nums.length; j++) {
            currSum += nums[j];
            if (currSum == k) {
               count++;
            }
         }
      }
      return count;
   }
}
