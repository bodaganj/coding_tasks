package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

public class JumpInt {

   public static void main(String[] args) {
      System.out.println(canJump(new int[]{1, 3, 2}));
      System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
      System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
      System.out.println(canJump(new int[]{3, 2, 0, 0, 4}));
      System.out.println(canJump(new int[]{1, 0, 1, 0}));
      System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
   }

   private static boolean canJump(int[] nums) {
      int lastTrueIndex = nums.length - 1;
      for (int i = nums.length - 2; i >= 0; i--) {
         if (i + nums[i] >= lastTrueIndex) {
            lastTrueIndex = i;
         }
      }

      return lastTrueIndex == 0;
   }
}
