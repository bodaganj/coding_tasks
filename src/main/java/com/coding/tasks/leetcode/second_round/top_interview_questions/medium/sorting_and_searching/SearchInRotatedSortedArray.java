package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.sorting_and_searching;

public class SearchInRotatedSortedArray {

   public static void main(String[] args) {
      System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
      System.out.println(search(new int[]{1}, 0));
      System.out.println(search(new int[]{1, 3}, 3));
      System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
      System.out.println(search(new int[]{5, 1, 3}, 5));
      System.out.println(search(new int[]{5, 1, 3}, 3));
      System.out.println(search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
   }

   private static int search(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      while (left <= right) {
         int mid = left + (right - left) / 2;

         if (nums[mid] == target) {
            return mid;
         } else if (nums[mid] >= nums[left]) {
            if (target >= nums[left] && target < nums[mid]) {
               right = mid - 1;
            } else {
               left = mid + 1;
            }
         } else {
            if (target <= nums[right] && target > nums[mid]) {
               left = mid + 1;
            } else {
               right = mid - 1;
            }
         }
      }

      return -1;
   }
}
