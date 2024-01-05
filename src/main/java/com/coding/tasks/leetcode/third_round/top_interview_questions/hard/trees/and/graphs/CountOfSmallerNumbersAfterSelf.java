package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.trees.and.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountOfSmallerNumbersAfterSelf {

   public static void main(String[] args) {
      int[] num = new int[]{5, 2, 6, 1};
      System.out.println(countSmaller(num));
      System.out.println(Arrays.toString(num));
   }

   public static List<Integer> countSmaller(int[] nums) {
      int[] ans = new int[nums.length];
      quickSort(0, nums.length - 1, nums, ans);
      return Arrays.stream(ans).boxed().collect(Collectors.toList());
   }

   private static void quickSort(int left, int right, int[] nums, int[] ans) {
      if (left == right) {
         return;
      }
      int pivot = pivot(left, right, nums);
      if (pivot - 1 >= 0) {
         quickSort(left, pivot - 1, nums, ans);
      }
      if (pivot + 1 < nums.length) {
         quickSort(pivot + 1, right, nums, ans);
      }
   }

   private static int pivot(int left, int right, int[] nums) {
      int mid = left + (right - left) / 2;
      int pivotValue = nums[mid];
      swap(mid, right, nums);
      int i = left;
      int j = right;
      while (i <= j) {
         while (i < right && nums[i] < pivotValue) {
            i++;
         }
         while (j >= left && nums[j] >= pivotValue) {
            j--;
         }
         if (i <= j) {
            swap(i, j, nums);
         }
      }
      swap(i, right, nums);
      return i;
   }

   private static void swap(int left, int right, int[] nums) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
   }

   public List<Integer> countSmaller111(int[] nums) {
      List<Integer> ans = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
         int count = 0;
         for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] > nums[j]) {
               count++;
            }
         }
         ans.add(count);
      }
      return ans;
   }
}
