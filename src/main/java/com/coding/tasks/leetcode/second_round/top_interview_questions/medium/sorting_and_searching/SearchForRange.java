package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.sorting_and_searching;

import java.util.Arrays;

public class SearchForRange {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(searchRange(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 8, 10, 10}, 4)));
      System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 2)));
      System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
      System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
      System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
      System.out.println(Arrays.toString(searchRange(new int[]{0, 0, 0, 1, 2, 3}, 0)));
   }

   private static int[] searchRange(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;
      while (left <= right) {
         int mid = left + (right - left) / 2;
         if (nums[mid] == target) {
            int start = getStart(nums, 0, mid, target);
            int end = getEnd(nums, mid, right, target);
            return new int[]{start, end};
         } else if (nums[mid] > target) {
            right = mid - 1;
         } else {
            left = mid + 1;
         }
      }

      return new int[]{-1, -1};
   }

   private static int getStart(int[] nums, int left, int right, int target) {
      int ans = right;
      while (left <= right) {
         int mid = left + (right - left) / 2;
         if (nums[mid] == target) {
            ans = mid;
            right = mid - 1;
         } else {
            left = mid + 1;
         }
      }
      return ans;
   }

   private static int getEnd(int[] nums, int left, int right, int target) {
      int ans = left;
      while (left <= right) {
         int mid = left + (right - left) / 2;
         if (nums[mid] == target) {
            ans = mid;
            left = mid + 1;
         } else {
            right = mid - 1;
         }
      }
      return ans;
   }
}
