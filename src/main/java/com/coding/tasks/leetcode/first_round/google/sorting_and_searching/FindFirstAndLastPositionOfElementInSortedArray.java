package com.coding.tasks.leetcode.first_round.google.sorting_and_searching;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
   }

   private static int[] searchRange(int[] nums, int target) {
      int indexOfAny = findIndexOfAny(nums, target);
      if (indexOfAny == -1) {
         return new int[]{-1, -1};
      } else {
         int left = findLeft(nums, target, indexOfAny);
         int right = findRight(nums, target, indexOfAny);
         return new int[]{left, right};
      }
   }

   private static int findRight(int[] nums, int target, int indexAny) {
      int left = indexAny;
      int right = nums.length - 1;

      while (left <= right) {
         int mid = left + (right - left) / 2;

         if (nums[mid] == target) {
            if (mid == nums.length - 1) {
               return nums.length - 1;
            } else if (nums[mid + 1] != target) {
               return mid;
            } else {
               left = mid + 1;
            }
         } else {
            if (nums[mid - 1] == target) {
               return mid - 1;
            } else {
               right = mid - 1;
            }
         }
      }

      return -1;
   }

   private static int findLeft(int[] nums, int target, int indexAny) {
      int left = 0;
      int right = indexAny;

      while (left <= right) {
         int mid = left + (right - left) / 2;

         if (nums[mid] == target) {
            if (mid == 0) {
               return 0;
            } else if (nums[mid - 1] != target) {
               return mid;
            } else {
               right = mid - 1;
            }
         } else {
            if (nums[mid + 1] == target) {
               return mid + 1;
            } else {
               left = mid + 1;
            }
         }
      }

      return -1;
   }

   private static int findIndexOfAny(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      while (left <= right) {
         int mid = left + (right - left) / 2;

         if (nums[mid] == target) {
            return mid;
         } else if (nums[mid] > target) {
            right = mid - 1;
         } else {
            left = mid + 1;
         }
      }

      return -1;
   }
}
