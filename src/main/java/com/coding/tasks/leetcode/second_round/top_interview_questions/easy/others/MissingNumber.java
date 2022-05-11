package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.others;

public class MissingNumber {

   public static void main(String[] args) {
      System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
      System.out.println(missingNumber(new int[]{0, 1}));
      System.out.println(missingNumber(new int[]{3, 0, 1}));
      System.out.println(missingNumber(new int[]{2, 0}));
      System.out.println(missingNumber(new int[]{1, 0}));
   }

   private static int missingNumber(int[] nums) {
      if (!isZeroPresent(nums)) {
         return 0;
      }

      markPresentIndexes(nums);

      for (int i = 1; i < nums.length; i++) {
         if (nums[i] >= 0) {
            return i;
         }
      }

      return nums.length;
   }

   private static boolean isZeroPresent(int[] nums) {
      for (int num : nums) {
         if (num == 0) {
            return true;
         }
      }
      return false;
   }

   private static void markPresentIndexes(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
         int value = Math.abs(nums[i]);

         if (value < nums.length) {
            if (nums[value] == 0) {
               nums[value] = -nums.length;
            } else {
               nums[value] *= -1;
            }
         }
      }
   }
}
