package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.sorting.and.searching;

public class SearchInRotatedSortedArray {

   public static void main(String[] args) {
      System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
      System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // -1
      System.out.println(search(new int[]{1}, 0)); // -1
      System.out.println(search(new int[]{1, 3}, 3)); // 1
      System.out.println(search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8)); // 4
      System.out.println(search(new int[]{5, 1, 3}, 3)); // 2
      System.out.println(search(new int[]{5, 1, 2, 3, 4}, 1)); // 1
   }

   public static int search(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;
      while (left <= right) {
         int mid = left + (right - left) / 2;
         if (nums[mid] == target) {
            return mid;
         } else if (nums[mid] > target) {
            if (nums[right] >= nums[mid] || target > nums[right]) {
               right = mid - 1;
            } else {
               left = mid + 1;
            }
         } else { // nums[mid] < target
            if (target <= nums[right] || nums[left] < nums[mid]) {
               left = mid + 1;
            } else {
               right = mid - 1;
            }
         }
      }
      return -1;
   }
}
