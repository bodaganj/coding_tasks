package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.others;

public class MissingNumber {

   public static void main(String[] args) {
      System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
      System.out.println(missingNumber(new int[]{0, 1}));
      System.out.println(missingNumber(new int[]{3, 0, 1}));
      System.out.println(missingNumber(new int[]{2, 0}));
   }

   private static int missingNumber(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
         int cur = Math.abs(nums[i]);
         if (cur == 10000) {
            nums[0] = -1;
         } else if (cur < nums.length) {
            if (nums[cur] == 0) {
               nums[cur] = -10000;
            } else {
               nums[cur] *= -1;
            }
         }
      }

      for (int i = 0; i < nums.length; i++) {
         if (nums[i] >= 0) {
            return i;
         }
      }
      return nums.length;
   }
}
