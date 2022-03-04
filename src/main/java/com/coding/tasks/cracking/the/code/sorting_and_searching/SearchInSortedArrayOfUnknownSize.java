package com.coding.tasks.cracking.the.code.sorting_and_searching;

public class SearchInSortedArrayOfUnknownSize {

   public static void main(String[] args) {
      System.out.println(search(new int[]{1, 3, 6, 7, 8, 9, 15}, 7));
      System.out.println(search(new int[]{1, 3, 6, 7, 8, 9, 15}, 10));
   }

   private static int search(int[] nums, int target) {
      int right = nums.length;
      int left = 0;

      while (left <= right) {
         int middle = left + (right - left) / 2;

         int tmp = nums[middle];
         if (tmp == target) {
            return middle;
         } else if (tmp < target) {
            left = middle + 1;
         } else {
            right = middle - 1;
         }
      }

      return -1;
   }
}