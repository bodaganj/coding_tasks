package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.sorting.and.searching;

public class MergeSortedArray {

   public void merge(int[] nums1, int m, int[] nums2, int n) {
      int p1 = m - 1;
      int p2 = n - 1;
      for (int i = nums1.length - 1; i >= 0; i--) {
         int v1 = p1 >= 0 ? nums1[p1] : Integer.MIN_VALUE;
         int v2 = p2 >= 0 ? nums2[p2] : Integer.MIN_VALUE;
         if (v1 > v2) {
            nums1[i] = v1;
            p1--;
         } else {
            nums1[i] = v2;
            p2--;
         }
      }
   }
}
