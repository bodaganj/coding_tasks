package com.coding.tasks.leetcode.google.arrays_and_strings;

import java.util.Arrays;

public class JumpInt {

   public static void main(String[] args) {
      System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
      System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
      System.out.println(canJump(new int[]{3, 2, 0, 0, 4}));
      System.out.println(canJump(new int[]{1, 0, 1, 0}));
      System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
   }

   private static boolean canJump(int[] nums) {
      if (nums.length == 1) {
         return true;
      }
      int length = nums.length;
      boolean[] flags = new boolean[length];
      Arrays.fill(flags, false);
      flags[0] = true;

      for (int i = 0; i < length - 1; i++) {
         for (int j = i + 1; j < i + 1 + nums[i] && j < length; j++) {
            if (!flags[j]) {
               flags[j] = true;
            }
         }
      }
      for (boolean flag : flags) {
         if (!flag) {
            return false;
         }
      }
      return true;
   }

   // greedy
//   public boolean canJump(int[] nums) {
//      int lastPos = nums.length - 1;
//      for (int i = nums.length - 1; i >= 0; i--) {
//         if (i + nums[i] >= lastPos) {
//            lastPos = i;
//         }
//      }
//      return lastPos == 0;
//   }


   // top !!
//   private static boolean canJump(int[] nums) {
//      int length = nums.length;
//      int max = 0;
//      for (int i = 0; i <= max; i++) {
//         max = Math.max(max, i + nums[i]);
//         if (max >= length - 1) {
//            return true;
//         }
//      }
//      return false;
//   }
}
