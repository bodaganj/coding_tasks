package com.coding.tasks.leetcode.second_round.google.sorting_and_searching;

import java.util.Arrays;

public class FindFirstAndLastPosition {

   public static void main(String[] args) {
      int[] nums1 = new int[]{5, 7, 7, 8, 8, 10};
      int[] nums2 = new int[]{1, 2, 3};

      int[] indexes1 = searchRange(nums1, 8);
      System.out.println(Arrays.toString(indexes1));

      int[] indexes2 = searchRange(nums2, 3);
      System.out.println(Arrays.toString(indexes2));
   }

   private static int[] searchRange(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      while (left <= right) {
         int mid = left + (right - left) / 2;

         if (nums[mid] == target) {
            int i = getLeft(nums, mid, target);
            int j = getRight(nums, mid, target);
            return new int[]{i, j};
         } else if (nums[mid] < target) {
            left = mid + 1;
         } else {
            right = mid - 1;
         }
      }

      return new int[]{-1, -1};
   }

   private static int getLeft(int[] nums, int right, int target) {
      int left = 0;
      while (left <= right) {
         int mid = left + (right - left) / 2;

         if (nums[mid] == target) {
            if (mid - 1 < 0) {
               return mid;
            } else {
               if (nums[mid - 1] != target) {
                  return mid;
               } else {
                  right = mid - 1;
               }
            }
         } else {
            left = mid + 1;
         }
      }

      return right;
   }

   private static int getRight(int[] nums, int left, int target) {
      int right = nums.length - 1;
      while (left <= right) {
         int mid = left + (right - left) / 2;

         if (nums[mid] == target) {
            if (mid + 1 > nums.length - 1) {
               return mid;
            } else {
               if (nums[mid + 1] != target) {
                  return mid;
               } else {
                  left = mid + 1;
               }
            }
         } else {
            right = mid - 1;
         }
      }

      return left;
   }
}
