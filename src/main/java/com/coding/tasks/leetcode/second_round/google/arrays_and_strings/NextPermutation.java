package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.Arrays;

public class NextPermutation {

   public static void main(String[] args) {
      int[] array1 = new int[]{5, 4, 3, 2, 1};
      System.out.println(Arrays.toString(array1));
      int[] array2 = new int[]{1, 2, 3};
      System.out.println(Arrays.toString(array2));
      int[] array3 = new int[]{2, 3, 1};
      System.out.println(Arrays.toString(array3));
      int[] array4 = new int[]{1, 3, 2};
      System.out.println(Arrays.toString(array4));
      int[] array5 = new int[]{2, 3, 1, 3, 3};
      System.out.println(Arrays.toString(array5));

      nextPermutation(array1);
      nextPermutation(array2);
      nextPermutation(array3);
      nextPermutation(array4);
      nextPermutation(array5);
      System.out.println("======");

      System.out.println(Arrays.toString(array1));
      System.out.println(Arrays.toString(array2));
      System.out.println(Arrays.toString(array3));
      System.out.println(Arrays.toString(array4));
      System.out.println(Arrays.toString(array5));
   }

   private static void nextPermutation(int[] nums) {
      int i = nums.length - 2;
      while (i >= 0 && nums[i + 1] <= nums[i]) {
         i--;
      }
      if (i >= 0) {
         int j = nums.length - 1;
         while (nums[j] <= nums[i]) {
            j--;
         }
         swap(nums, i, j);
      }
      reverse(nums, i + 1);
   }

   private static void reverse(int[] nums, int start) {
      int i = start, j = nums.length - 1;
      while (i < j) {
         swap(nums, i, j);
         i++;
         j--;
      }
   }

   private static void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }
}
