package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.array;

import java.util.Arrays;

public class MoveZeroes {

   public static void main(String[] args) {
      int[] array = new int[]{0, 1, 0, 3, 12};
      System.out.println(Arrays.toString(array));
      moveZeroes(array);
      System.out.println(Arrays.toString(array));
   }

   private static void moveZeroes(int[] nums) {
      int zeroCounter = -1;
      int i = 0;
      while (zeroCounter < 0 && i < nums.length) {
         if (nums[i] == 0) {
            zeroCounter = i;
         } else {
            i++;
         }
      }

      if (zeroCounter < 0) {
         return;
      }

      int current = zeroCounter + 1;
      while (current < nums.length) {
         if (nums[current] != 0) {
            swap(nums, zeroCounter, current);
            zeroCounter++;
         }
         current++;
      }
   }

   private static void swap(int[] nums, int left, int right) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
   }
}
