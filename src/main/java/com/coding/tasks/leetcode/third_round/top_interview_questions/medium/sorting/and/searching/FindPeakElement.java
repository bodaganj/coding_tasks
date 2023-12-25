package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.sorting.and.searching;

public class FindPeakElement {

   public static void main(String[] args) {
      System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
   }

   public static int findPeakElement(int[] nums) {
      if (nums.length == 1) {
         return 0;
      }
      int[] bigger = new int[nums.length + 2];
      bigger[0] = bigger[bigger.length - 1] = Integer.MIN_VALUE;
      System.arraycopy(nums, 0, bigger, 1, nums.length);

      return mergeSearch(bigger, 1, bigger.length - 2);
   }

   private static int mergeSearch(int[] bigger, int left, int right) {
      if (left <= 0 || right >= bigger.length - 1) {
         return -1;
      } else {
         int mid = left + (right - left) / 2;
         if (bigger[mid] > bigger[mid + 1] && bigger[mid] > bigger[mid - 1]) {
            return mid - 1;
         } else if (bigger[mid] < bigger[mid + 1]) {
            return mergeSearch(bigger, mid + 1, right);
         } else {
            return mergeSearch(bigger, left, mid - 1);
         }
      }
   }
}
