package com.coding.tasks.leetcode.amazon.sorting_and_searching;

public class SearchInRotatedSortedArray {

   public static void main(String[] args) {
      System.out.println(search(new int[]{5, 1, 3}, 3));
//      System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//      System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
   }

   private static int search(int[] nums, int target) {
      if (nums == null) {
         return -1;
      }

      if (nums.length == 1) {
         return nums[0] == target ? 0 : -1;
      }

      int start = 0;
      int end = nums.length - 1;

      while (start <= end) {
         int midIndex = start + (end - start) / 2;
         int mid = nums[midIndex];

         if (mid == target) {
            return midIndex;
         }

         if (mid < nums[end] && mid < nums[start]) {
            if (mid < target && target <= nums[end]) {
               start = midIndex + 1;
            } else {
               end = midIndex - 1;
            }
         } else {
            if (mid > target && target >= nums[start]) {
               end = midIndex - 1;
            } else {
               start = midIndex + 1;
            }
         }
      }

      return -1;
   }
}
