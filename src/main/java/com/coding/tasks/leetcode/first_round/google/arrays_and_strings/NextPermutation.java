package com.coding.tasks.leetcode.first_round.google.arrays_and_strings;

import java.util.Arrays;

public class NextPermutation {

   public static void main(String[] args) {
//      int[] array1 = new int[]{5, 4, 3, 2, 1};
//      System.out.println(Arrays.toString(array1));
//      int[] array2 = new int[]{1, 2, 3};
//      System.out.println(Arrays.toString(array2));
      int[] array3 = new int[]{2, 3, 1};
      System.out.println(Arrays.toString(array3));

//      nextPermutation(array1);
//      nextPermutation(array2);
      nextPermutation(array3);

//      System.out.println(Arrays.toString(array1));
//      System.out.println(Arrays.toString(array2));
      System.out.println(Arrays.toString(array3));
   }

   private static void nextPermutation(int[] nums) {
      int decreasingIndex = findFirstDecreasingIndex(nums);
      if (decreasingIndex == -1) {
         reverse(nums, 0);
      } else {
         int increasingIndex = findIncreasing(nums, decreasingIndex);
         int tmp = nums[decreasingIndex];
         nums[decreasingIndex] = nums[increasingIndex];
         nums[increasingIndex] = tmp;
         reverse(nums, decreasingIndex + 1);
      }
   }

   private static int findFirstDecreasingIndex(int[] nums) {
      for (int i = nums.length - 2; i >= 0; i--) {
         if (nums[i] < nums[i + 1]) {
            return i;
         }
      }
      return -1;
   }

   private static int findIncreasing(int[] nums, int decreasingIndex) {
      int increasingIndex = -1;
      int currentMax = Integer.MAX_VALUE;
      for (int i = decreasingIndex + 1; i < nums.length; i++) {
         if (nums[i] > nums[decreasingIndex]) {
            currentMax = Math.min(currentMax, nums[i]);
            if (currentMax == nums[i]) {
               increasingIndex = i;
            }
         }
      }
      return increasingIndex;
   }

   private static void reverse(int[] nums, int decreasingIndex) {
      int i = decreasingIndex;
      int j = nums.length - 1;
      while (i < j) {
         int tmp = nums[i];
         nums[i] = nums[j];
         nums[j] = tmp;
         i++;
         j--;
      }
   }
}
