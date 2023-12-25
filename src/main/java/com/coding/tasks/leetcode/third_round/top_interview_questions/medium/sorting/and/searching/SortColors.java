package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.sorting.and.searching;

import java.util.Arrays;

public class SortColors {

   public static void main(String[] args) {
      int[] arr = new int[]{1, 2, 1, 1, 2, 0, 0, 1};
      sortColors(arr);
      System.out.println(Arrays.toString(arr));

      int[] arr1 = new int[]{2, 0, 2, 1, 1, 0};
      sortColors(arr1);
      System.out.println(Arrays.toString(arr1));

      int[] arr2 = new int[]{2, 1};
      sortColors(arr2);
      System.out.println(Arrays.toString(arr2));

      int[] arr3 = new int[]{1, 2};
      sortColors(arr3);
      System.out.println(Arrays.toString(arr3));

      int[] arr4 = new int[]{2, 0, 1};
      sortColors(arr4);
      System.out.println(Arrays.toString(arr4));
   }

   public static void sortColors(int[] nums) {
      int zero = 0;
      int two = nums.length - 1;
      int i = 0;
      while (i < nums.length && i <= two) {
         if (nums[i] == 0) {
            swap(nums, zero, i);
            zero++;
            i++;
         } else if (nums[i] == 2) {
            swap(nums, i, two);
            two--;
         } else {
            i++;
         }
      }
   }

   private static void swap(int[] nums, int left, int right) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
   }
}
