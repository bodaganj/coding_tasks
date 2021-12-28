package com.coding.tasks.leetcode.top.interview.questions.easy.array;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

   public static void main(String[] args) {
      int[] array = new int[]{0, 0, 0, 1, 2, 2, 2, 2, 3, 5, 5, 5};
      int[] array2 = new int[]{-3, -1, -1};
      System.out.println(Arrays.toString(array));
      System.out.println(removeDuplicates(array));
      System.out.println(Arrays.toString(array));

      System.out.println(Arrays.toString(array2));
      System.out.println(removeDuplicates(array2));
      System.out.println(Arrays.toString(array2));
   }

   /**
    * best case!!!
    * @param nums
    * @return
    */
//   private static int removeDuplicates(int[] nums) {
//      if (nums.length == 0) {
//         return 0;
//      }
//      int i = 0;
//      for (int j = 1; j < nums.length; j++) {
//         if (nums[j] != nums[i]) {
//            i++;
//            nums[i] = nums[j];
//         }
//      }
//      return i + 1;
//   }
   private static int removeDuplicates(int[] nums) {
      if (nums.length == 0) {
         return 0;
      }

      for (int i = nums.length - 1; i > 0; i--) {
         if (nums[i] == nums[i - 1]) {
            nums[i] = nums[0];
         }
      }

      int freeIndex = 0;
      boolean doWeHaveFreeIndex = false;
      int i = 0;
      while (i != nums.length - 1) {
         if (nums[i] >= nums[i + 1] && !doWeHaveFreeIndex) {
            freeIndex = i + 1;
            doWeHaveFreeIndex = true;
            i++;
         } else if (nums[i] >= nums[i + 1] && doWeHaveFreeIndex) {
            i++;
         } else if (nums[i] < nums[i + 1] && doWeHaveFreeIndex) {
            nums[freeIndex] = nums[i + 1];
            nums[i + 1] = nums[0];
            doWeHaveFreeIndex = false;
            i = freeIndex;
         } else {
            i++;
         }
      }

      int j = 0;
      while (j < nums.length - 1) {
         if (nums[j] < nums[j + 1]) {
            j++;
         } else {
            return j + 1;
         }
      }
      return j + 1;
   }
}
