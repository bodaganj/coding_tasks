package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.sorting_and_searching;

import java.util.Arrays;

public class MergeSortedArray {

   public static void main(String[] args) {
      int[] arr = {1, 2, 3, 0, 0, 0};
      System.out.println(Arrays.toString(arr));
      merge(arr, 3, new int[]{2, 5, 6}, 3);
      System.out.println(Arrays.toString(arr));
   }

   private static void merge(int[] nums1, int m, int[] nums2, int n) {
   }
}
