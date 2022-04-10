package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.array;

import java.util.Arrays;

public class RotateArray {

   public static void main(String[] args) {
      int[] arr1 = new int[]{1, 2};
      System.out.println(Arrays.toString(arr1));
      rotate(arr1, 5);
      System.out.println(Arrays.toString(arr1));

      int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7};
      System.out.println(Arrays.toString(arr2));
      rotate(arr2, 3);
      System.out.println(Arrays.toString(arr2));
   }

   private static void rotate(int[] nums, int k) {
      k %= nums.length;

      swap(nums, 0, nums.length - k - 1);
      swap(nums, nums.length - k, nums.length - 1);
      swap(nums, 0, nums.length - 1);
   }

   private static void swap(int[] nums, int left, int right) {
      while (left < right) {
         int tmp = nums[left];
         nums[left] = nums[right];
         nums[right] = tmp;
         left++;
         right--;
      }
   }

   // TLE
   private static void rotate1(int[] nums, int k) {
      k %= nums.length;

      int length = nums.length;
      for (int j = 0; j < k; j++) {
         int tmp = nums[0];
         int toMove = nums[length - 1];

         for (int i = 0; i < length; i++) {
            nums[i] = toMove;
            toMove = tmp;
            if ((i + 1) < length) {
               tmp = nums[i + 1];
            }
         }
      }
   }
}
