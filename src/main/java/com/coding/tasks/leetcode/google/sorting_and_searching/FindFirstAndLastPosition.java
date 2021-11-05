package com.coding.tasks.leetcode.google.sorting_and_searching;

public class FindFirstAndLastPosition {

   private static FindFirstAndLastPosition findFirstAndLastPosition = new FindFirstAndLastPosition();

   public static void main(String[] args) {
      int[] nums1 = new int[]{5, 7, 7, 8, 8, 10};
      int[] nums2 = new int[]{1, 2, 3};
      int[] indexes2 = findFirstAndLastPosition.searchRange(nums2, 3);
      int[] indexes1 = findFirstAndLastPosition.searchRange(nums1, 8);
      for (int index : indexes2) {
         System.out.print(index + " ");
      }
      System.out.println();
      for (int index : indexes1) {
         System.out.print(index + " ");
      }
   }

   public int[] searchRange(int[] nums, int target) {
      int firstOccurrence = this.findBound(nums, target, true);
      if (firstOccurrence == -1) {
         return new int[]{-1, -1};
      }
      int lastOccurrence = this.findBound(nums, target, false);
      return new int[]{firstOccurrence, lastOccurrence};
   }

   private int findBound(int[] nums, int target, boolean isFirst) {
      int length = nums.length;
      int begin = 0, end = length - 1;

      while (begin <= end) {
         int mid = (begin + end) / 2;

         if (nums[mid] == target) {
            if (isFirst) {
               if (mid == begin || nums[mid - 1] != target) {
                  return mid;
               } else {
                  end = mid - 1;
               }
            } else {
               if (mid == end || nums[mid + 1] != target) {
                  return mid;
               } else {
                  begin = mid + 1;
               }
            }
         } else if (nums[mid] > target) {
            end = mid - 1;
         } else {
            begin = mid + 1;
         }
      }
      return -1;
   }
}
