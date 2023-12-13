package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.array;

public class MoveZeroes {

   public static void main(String[] args) {

   }

   public static void moveZeroes(int[] nums) {
      int zeroIndex = getFirstZeroIndex(nums);
      if (zeroIndex > -1) {
         int right = zeroIndex + 1;
         while (right < nums.length) {
            if (nums[right] != 0) {
               swap(nums, zeroIndex, right);
               zeroIndex++;
            }
            right++;
         }
      }
   }

   private static int getFirstZeroIndex(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] == 0) {
            return i;
         }
      }
      return -1;
   }

   private static void swap(int[] nums, int left, int right) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
   }
}
