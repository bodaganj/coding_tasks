package com.coding.tasks.leetcode.second_round.amazon.arrays_and_strings;

public class MissingNumber {

   public static void main(String[] args) {
      System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
      System.out.println(missingNumber(new int[]{3, 0, 1}));
      System.out.println(missingNumber(new int[]{0, 1}));
      System.out.println(missingNumber(new int[]{1}));
      System.out.println(missingNumber(new int[]{2, 0}));
   }

   private static int missingNumber(int[] nums) {
      // check if 0 is present
      boolean present = false;
      for (int num : nums) {
         if (num == 0) {
            present = true;
            nums[0] *= -1;
            break;
         }
      }
      if (!present) {
         return 0;
      }

      // set all present indexes to negative values
      for (int num : nums) {
         int abs = Math.abs(num);
         if (abs > 0 && abs < nums.length) {
            if (nums[abs] == 0) {
               nums[abs] = -nums.length;
            } else {
               nums[abs] *= -1;
            }
         }
      }

      // get positive index as an answer
      for (int i = 1; i < nums.length; i++) {
         if (nums[i] >= 0) {
            return i;
         }
      }

      return nums.length;
   }
}
