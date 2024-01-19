package com.coding.tasks.leetcode.third_round.top_interview_questions.google.arrays.and.strings;

import java.util.Arrays;

public class NextPermutation {

   public static void main(String[] args) {
      int[] ints1 = {1}; // 1
      nextPermutation(ints1);
      System.out.println(Arrays.toString(ints1));

      int[] ints2 = {1, 3, 2}; // 2,1,3
      nextPermutation(ints2);
      System.out.println(Arrays.toString(ints2));

      int[] ints3 = {2, 3, 1}; // 3,1,2
      nextPermutation(ints3);
      System.out.println(Arrays.toString(ints3));

      int[] ints4 = {4, 2, 0, 2, 3, 2, 0}; // 4,2,0,3,0,2,2
      nextPermutation(ints4);
      System.out.println(Arrays.toString(ints4));
   }

   public static void nextPermutation(int[] nums) {
      if (nums.length <= 1) {
         return;
      }

      for (int i = nums.length - 2; i >= 0; i--) {
         for (int j = nums.length - 1; j > i; j--) {
            if (nums[i] < nums[j]) {
               swap(i, j, nums);
               reverse(i + 1, nums);
               return;
            }
         }
      }
      reverse(0, nums);
   }

   private static void reverse(int left, int[] nums) {
      int right = nums.length - 1;
      while (left < right) {
         swap(left, right, nums);
         left++;
         right--;
      }
   }

   private static void swap(int left, int right, int[] nums) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
   }
}
