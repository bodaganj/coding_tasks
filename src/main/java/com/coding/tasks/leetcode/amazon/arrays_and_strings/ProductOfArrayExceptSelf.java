package com.coding.tasks.leetcode.amazon.arrays_and_strings;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
   }

   private static int[] productExceptSelf(int[] nums) {
      int[] finalArr = new int[nums.length];

      int item = 1;
      for (int i = 0; i < nums.length; i++) {
         finalArr[i] = item;
         item = item * nums[i];
      }

      item = 1;
      for (int i = nums.length - 1; i >= 0; i--) {
         finalArr[i] = finalArr[i] * item;
         item = item * nums[i];
      }

      return finalArr;
   }
}
