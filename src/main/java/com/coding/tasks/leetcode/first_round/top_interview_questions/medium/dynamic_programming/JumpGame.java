package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.dynamic_programming;

public class JumpGame {

   public static void main(String[] args) {
      System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
      System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
      System.out.println(canJump(new int[]{2, 5, 0, 0}));
   }

   private static boolean canJump(int[] nums) {
      int length = nums.length;
      boolean[] flags = new boolean[length];
      flags[length - 1] = true;

      for (int i = length - 2; i >= 0; i--) {
         if (i + nums[i] >= length - 1) {
            flags[i] = true;
         }

         for (int j = 1; j <= nums[i]; j++) {
            if (flags[i + j]) {
               flags[i] = true;
               break;
            }
         }
      }

      return flags[0];
   }

   /**
    * WOW....
    */
   public boolean canJump1(int[] nums) {
      int lastPos = nums.length - 1;
      for (int i = nums.length - 1; i >= 0; i--) {
         if (i + nums[i] >= lastPos) {
            lastPos = i;
         }
      }
      return lastPos == 0;
   }
}
