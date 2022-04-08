package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.sorting_and_searching;

import java.util.Arrays;

public class MergeSortedArray {

   public static void main(String[] args) {
      int[] arr = {1, 2, 3, 0, 0, 0};
      System.out.println(Arrays.toString(arr));
      merge(arr, 3, new int[]{2, 5, 6}, 3);
      System.out.println(Arrays.toString(arr));
   }

   private static void merge(int[] nums1, int m, int[] nums2, int n) {
      int fIndex = nums1.length - n - 1;
      int sIndex = n - 1;

      for (int i = nums1.length - 1; i >= 0; i--) {
         int fValue = fIndex >= 0 ? nums1[fIndex] : Integer.MIN_VALUE;
         int sValue = sIndex >= 0 ? nums2[sIndex] : Integer.MIN_VALUE;

         if (fValue > sValue) {
            nums1[i] = fValue;
            fIndex--;
         } else {
            nums1[i] = sValue;
            sIndex--;
         }
      }
   }
}
