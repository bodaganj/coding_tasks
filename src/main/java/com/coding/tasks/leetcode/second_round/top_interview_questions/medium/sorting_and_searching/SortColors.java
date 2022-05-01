package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.sorting_and_searching;

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

   private static void sortColors(int[] nums) {
      int curr = 0;
      int p0 = 0;
      int p2 = nums.length - 1;

      while (curr <= p2) {
         if (nums[curr] == 0) {
            swap(nums, p0, curr);
            curr++;
            p0++;
         } else if (nums[curr] == 2) {
            swap(nums, curr, p2);
            p2--;
         } else {
            curr++;
         }
      }
   }

   private static void swap(int[] nums, int left, int right) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
   }
}
