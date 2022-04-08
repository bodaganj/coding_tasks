package com.coding.tasks.leetcode.first_round.google.arrays_and_strings;

import java.util.Arrays;

public class KthLargestElement {

   public static void main(String[] args) {
      System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
      System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
   }

   private static int findKthLargest(int[] nums, int k) {
      Arrays.sort(nums);
      int counter = 1;
      for (int i = nums.length - 1; i >= 0; i--) {
         if (counter == k) {
            return nums[i];
         }
         counter++;
      }
      return 0;
   }
}
