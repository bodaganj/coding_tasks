package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.sorting_and_searching;

public class FindPeakElement {

   public static void main(String[] args) {
      System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
      System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
   }

   private static int findPeakElement(int[] nums) {
      int left = 0;
      int right = nums.length - 1;

      while (left < right) {
         int mid = left + (right - left) / 2;

         int rightVal = mid + 1 < nums.length ? nums[mid + 1] : Integer.MIN_VALUE;
         int leftVal = mid - 1 >= 0 ? nums[mid - 1] : Integer.MIN_VALUE;
         if (nums[mid] > leftVal && nums[mid] > rightVal) {
            return mid;
         } else if (nums[mid] < leftVal) {
            right = mid - 1;
         } else {
            left = mid + 1;
         }
      }
      return left;
   }
}
