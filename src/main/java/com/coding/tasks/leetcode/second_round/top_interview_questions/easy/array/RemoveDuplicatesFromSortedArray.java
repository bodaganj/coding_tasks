package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.array;

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

   private static int removeDuplicates(int[] nums) {
      int i = 1;
      int current = nums[0];

      for (int counter = 1; counter < nums.length; counter++) {
         if (nums[counter] > current) {
            current = nums[counter];
            nums[i] = current;
            i++;
         }
      }

      return i;
   }
}
