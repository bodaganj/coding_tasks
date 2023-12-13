package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.array;

import java.util.Arrays;

public class RotateArray {

   public static void main(String[] args) {
      int[] ints1 = {1, 2, 3, 4, 5, 6, 7};
      rotate(ints1, 3);
      System.out.println(Arrays.toString(ints1));

      int[] ints2 = {1};
      rotate(ints2, 3);
      System.out.println(Arrays.toString(ints2));
   }

   public static void rotate(int[] nums, int k) {
      while (k > nums.length) {
         k -= nums.length;
      }
      revert(nums, 0, nums.length - 1);
      revert(nums, 0, k - 1);
      revert(nums, k, nums.length - 1);
   }

   private static void revert(int[] nums, int left, int right) {
      while (left < right) {
         swap(nums, left, right);
         left++;
         right--;
      }
   }

   private static void swap(int[] nums, int left, int right) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
   }
}
