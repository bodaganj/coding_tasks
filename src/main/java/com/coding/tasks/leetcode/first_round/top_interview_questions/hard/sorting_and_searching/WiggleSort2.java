package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.sorting_and_searching;

import java.util.Arrays;

public class WiggleSort2 {

   public static void main(String[] args) {
      int[] arr1 = new int[]{1, 5, 1, 1, 6, 4};
      int[] arr2 = new int[]{1, 3, 2, 2, 3, 1};

//      System.out.println(Arrays.toString(arr1));
      System.out.println(Arrays.toString(arr2));

//      wiggleSort(arr1);
      wiggleSort(arr2);

//      System.out.println(Arrays.toString(arr1));
      System.out.println(Arrays.toString(arr2));
   }

   private static void wiggleSort(int[] nums) {
      int i = 0;
      int j = 1;
      boolean isHigher = true;

      while (i < nums.length && j < nums.length) {
         if (isHigher) {
            if (i == j - 1 && nums[i] < nums[j]) {
               i++;
               j++;
               isHigher = false;
            } else if (nums[i] >= nums[j]) {
               j++;
            } else if (nums[i] < nums[j]) {
               swap(nums, i + 1, j);
               i++;
               j = i + 1;
               isHigher = false;
            }
         } else {
            if (i == j - 1 && nums[i] > nums[j]) {
               i++;
               j++;
               isHigher = true;
            } else if (nums[i] <= nums[j]) {
               j++;
            } else if (nums[i] > nums[j]) {
               swap(nums, i + 1, j);
               i++;
               j = i + 1;
               isHigher = true;
            }
         }
      }
   }

   private static void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
   }
}
