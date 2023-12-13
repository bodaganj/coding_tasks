package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.array;

public class RemoveDuplicatesFromSortedArray {

   public static void main(String[] args) {
      System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
      System.out.println(removeDuplicates(new int[]{1, 2, 2}));
      System.out.println(removeDuplicates(new int[]{1, 1, 2, 2}));
   }

   public static int removeDuplicates(int[] nums) {
      if (nums.length == 0) {
         return 0;
      }

      int left = 1;
      int currentBiggest = nums[0];

      for (int i = 1; i < nums.length; i++) {
         int current = nums[i];

         if (current > currentBiggest) {
            currentBiggest = current;
            nums[left] = current;
            left++;
         }
      }
      return left;
   }
}
