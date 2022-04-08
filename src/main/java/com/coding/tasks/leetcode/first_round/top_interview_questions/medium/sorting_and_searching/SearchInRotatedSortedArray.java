package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.sorting_and_searching;

public class SearchInRotatedSortedArray {

   // 37 min
   public static void main(String[] args) {
      System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
      System.out.println(search(new int[]{1}, 0));
      System.out.println(search(new int[]{1, 3}, 3));
      System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
   }

   private static int search(int[] nums, int target) {
      if (nums == null) {
         return -1;
      }
      if (nums.length == 1) {
         return nums[0] == target ? 0 : -1;
      }

      return search(nums, target, 0, nums.length - 1);
   }

   private static int search(int[] nums, int target, int left, int right) {
      int last = nums[nums.length - 1];

      while (left <= right) {
         int middle = left + (right - left) / 2;
         int mid = nums[middle];

//         if (mid == target) {
//            return middle;
//         } else if (mid < target && mid < last) {
//            left = middle + 1;
//         } else if (mid > target && mid < last) {
//            right = middle - 1;
//         } else if (mid < target && mid > last) {
//            right = middle + 1;
//         } else if (mid > target && mid > last) {
//            left = middle + 1;
//         }

         if (target == mid) {
            return middle;
         } else if (target < mid && target < last) {
            left = middle + 1;
         } else if (target < mid && target > last) {
            right = middle - 1;
         } else if ((target > mid && target < last) || (target > mid && target > last)) {
            left = middle + 1;
         }
      }

      return -1;
   }
}
