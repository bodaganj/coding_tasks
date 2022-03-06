package com.coding.tasks.leetcode.top.interview.questions.medium.sorting_and_searching;

import java.util.Arrays;

public class SearchForRange {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(searchRange(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 8, 10, 10}, 4)));
//      System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 2)));
//      System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//      System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
   }

   private static int[] searchRange(int[] nums, int target) {
      int indexOfTarget = getIndexOfTarget(nums, target);

      if (indexOfTarget == -1) {
         return new int[]{-1, -1};
      } else {
         int left = getLeftIndexes(nums, target, indexOfTarget);
         int right = getRightIndexes(nums, target, indexOfTarget);
         return new int[]{left, right};
      }
   }

   private static int getRightIndexes(int[] nums, int target, int index) {
      int left = index;
      int right = nums.length - 1;

      while (left <= right) {
         int middle = left + (right - left) / 2;

         if (nums[middle] == target) {
            if (middle + 1 > nums.length - 1) {
               return nums.length - 1;
            }

            if (nums[middle + 1] != target) {
               return middle;
            } else {
               left = middle + 1;
            }
         } else {
            if (nums[middle - 1] == target) {
               return middle - 1;
            } else {
               right = middle - 1;
            }
         }
      }

      return nums.length - 1;
   }

   private static int getLeftIndexes(int[] nums, int target, int index) {
      int left = 0;
      int right = index - 1;

      while (left <= right) {
         int middle = left + (right - left) / 2;

         if (nums[middle] == target) {
            if (middle - 1 < 0) {
               return 0;
            }

            if (nums[middle - 1] != target) {
               return middle;
            } else {
               right = middle - 1;
            }
         } else {
            if (nums[middle + 1] == target) {
               return middle + 1;
            } else {
               left = middle + 1;
            }
         }
      }

      return 0;
   }

   private static int getIndexOfTarget(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      while (left <= right) {
         int middle = left + (right - left) / 2;

         if (nums[middle] == target) {
            return middle;
         } else if (nums[middle] > target) {
            right = middle - 1;
         } else {
            left = middle + 1;
         }
      }

      return -1;
   }
}
