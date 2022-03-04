package com.coding.tasks.leetcode.top.interview.questions.medium.sorting_and_searching;

import java.util.Arrays;

public class SortColors {

   public static void main(String[] args) {
      int[] arr = new int[]{1, 2, 1, 1, 2, 0, 0, 1};
      System.out.println(Arrays.toString(arr));
      sortColors(arr);
      System.out.println(Arrays.toString(arr));
   }

   private static void sortColors(int[] nums) {
      int left = 0;
      int right = nums.length - 1;
      int curr = 0;

      while (curr <= right) {
         if (nums[curr] == 2) {
            swap(nums, curr, right);
            right--;
         } else if (nums[curr] == 0) {
            swap(nums, curr, left);
            curr++;
            left++;
         } else {
            curr++;
         }
      }
   }

   private static void swap(int[] nums, int first, int second) {
      int tmp = nums[first];
      nums[first] = nums[second];
      nums[second] = tmp;
   }
}
