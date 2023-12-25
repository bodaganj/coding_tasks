package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.sorting.and.searching;

import java.util.Arrays;

public class SearchForRange {

   public static void main(String[] args) {
//      System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
      System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
//      System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
//      System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 2)));
   }

   public static int[] searchRange(int[] nums, int target) {
      int[] dummy = new int[nums.length + 2];
      dummy[0] = Integer.MIN_VALUE;
      dummy[dummy.length - 1] = Integer.MAX_VALUE;
      System.arraycopy(nums, 0, dummy, 1, nums.length);
      return new int[]{findLeft(dummy, target), findRight(dummy, target)};
   }

   private static int findLeft(int[] nums, int target) {
      int left = 1;
      int right = nums.length - 2;
      while (left <= right) {
         int mid = left + (right - left) / 2;
         if (nums[mid] == target) {
            if (nums[mid] > nums[mid - 1]) {
               return mid - 1;
            } else {
               right = mid;
            }
         } else if (nums[mid] > target) {
            right = mid - 1;
         } else {
            left = mid + 1;
         }
      }
      return -1;
   }

   private static int findRight(int[] nums, int target) {
      int left = 1;
      int right = nums.length - 2;
      while (left <= right) {
         int mid = left + (right - left) / 2;
         if (nums[mid] == target) {
            if (nums[mid] < nums[mid + 1]) {
               return mid - 1;
            } else {
               left = mid + 1;
            }
         } else if (nums[mid] > target) {
            right = mid - 1;
         } else {
            left = mid + 1;
         }
      }
      return -1;
   }
}
