package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.array.and.strings;

public class FindTheDuplicateNumber {

   public static void main(String[] args) {
      System.out.println(findDuplicate(new int[]{1, 2, 3, 4, 3}));
   }

   public static int findDuplicate(int[] nums) {
      int left = nums[0];
      int right = nums[0];
      do {
         left = nums[left];
         right = nums[nums[right]];
      } while (left != right);

      right = nums[0];
      while (left != right) {
         left = nums[left];
         right = nums[right];
      }
      return left;
   }
}
