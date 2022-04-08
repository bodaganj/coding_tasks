package com.coding.tasks.leetcode.first_round.amazon.arrays_and_strings;

public class MissingNumber {

   public static void main(String[] args) {
      System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
      System.out.println(missingNumber(new int[]{3, 0, 1}));
      System.out.println(missingNumber(new int[]{0, 1}));
      System.out.println(missingNumber(new int[]{1}));
   }

   private static int missingNumber(int[] nums) {
      int sum = 0;
      for (int i = 0; i <= nums.length; i++) {
         sum += i;
      }

      for (int num : nums) {
         sum -= num;
      }
      return sum;
   }
}
