package com.coding.tasks.leetcode.amazon.sorting_and_searching;

import java.util.Arrays;

public class TwoSum2InputArrayIsSorted {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
   }

   private static int[] twoSum(int[] numbers, int target) {
      int i = 1;
      numbers[0] = target - numbers[0];

      while (i < numbers.length) {
         for (int j = 0; j < i; j++) {
            if (numbers[j] == numbers[i]) {
               return new int[]{j + 1, i + 1};
            }
         }

         numbers[i] = target - numbers[i];
         i++;
      }

      return new int[2];
   }
}
