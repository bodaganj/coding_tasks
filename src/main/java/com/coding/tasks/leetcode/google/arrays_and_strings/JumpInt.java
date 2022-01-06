package com.coding.tasks.leetcode.google.arrays_and_strings;

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
      boolean[] boolArray = new boolean[nums.length];
      boolArray[boolArray.length - 1] = true;

      for (int i = 0; i < nums.length - 1; i++) {
         int j = 0;
         while (j < nums[i] && (i + j) < boolArray.length) {
            boolArray[i + j] = true;
            j++;
         }
      }

      for (boolean b : boolArray) {
         if (!b) {
            return false;
         }
      }
      return true;
   }

//   private static boolean canJump(int[] nums) {
//      if (nums.length == 1) {
//         return true;
//      }
//      int length = nums.length;
//      boolean[] flags = new boolean[length];
//      Arrays.fill(flags, false);
//      flags[0] = true;
//
//      for (int i = 0; i < length - 1; i++) {
//         for (int j = i + 1; j < i + 1 + nums[i] && j < length; j++) {
//            if (!flags[j]) {
//               flags[j] = true;
//            }
//         }
//      }
//      for (boolean flag : flags) {
//         if (!flag) {
//            return false;
//         }
//      }
//      return true;
//   }
}
