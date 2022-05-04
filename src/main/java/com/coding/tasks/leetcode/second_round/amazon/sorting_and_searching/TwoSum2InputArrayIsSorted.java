package com.coding.tasks.leetcode.second_round.amazon.sorting_and_searching;

import java.util.Arrays;

public class TwoSum2InputArrayIsSorted {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
      System.out.println(Arrays.toString(twoSum(new int[]{5, 25, 75}, 100)));
      System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
   }

   private static int[] twoSum(int[] numbers, int target) {
      int left = 0;
      int right = numbers.length - 1;

      while (left < right) {
         int sum = numbers[left] + numbers[right];
         if (sum == target) {
            return new int[]{left + 1, right + 1};
         } else if (sum > target) {
            right--;
         } else {
            left++;
         }
      }

      return new int[0];
   }
}
