package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.sorting_and_searching;

import java.util.Arrays;

public class MergeSortedArray {

   public static void main(String[] args) {
      int[] arr = {1, 2, 3, 0, 0, 0};
      merge(arr, 3, new int[]{2, 5, 6}, 3);
      System.out.println(Arrays.toString(arr));

      int[] arr1 = {0};
      merge(arr1, 0, new int[]{1}, 1);
      System.out.println(Arrays.toString(arr1));
   }

   private static void merge(int[] nums1, int m, int[] nums2, int n) {
      int i = nums1.length - 1;
      int left = m - 1;
      int right = n - 1;

      while (i >= 0) {
         int nums1Val = left >= 0 ? nums1[left] : Integer.MIN_VALUE;
         int nums2Val = right >= 0 ? nums2[right] : Integer.MIN_VALUE;

         if (nums1Val >= nums2Val) {
            nums1[i--] = nums1[left--];
         } else {
            nums1[i--] = nums2[right--];
         }
      }
   }
}
