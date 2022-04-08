package com.coding.tasks.leetcode.first_round.amazon.sorting_and_searching;

import java.util.Arrays;

public class TwoSum2InputArrayIsSorted {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
      System.out.println(Arrays.toString(twoSum(new int[]{5, 25, 75}, 100)));
      System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
   }

   private static int[] twoSum(int[] numbers, int target) {
      int i = 1;
      numbers[0] = target - numbers[0];

      while (i < numbers.length) {
         int index = getIndex(numbers, numbers[i], 0, i - 1);
         if (index != -1) {
            return new int[]{index + 1, i + 1};
         }

         numbers[i] = target - numbers[i];
         i++;
      }

      return new int[2];
   }

   private static int getIndex(int[] numbers, int target, int left, int right) {
      while (left <= right) {
         int mid = left + (right - left) / 2;

         if (numbers[mid] == target) {
            return mid;
         } else if (numbers[mid] > target) {
            left = mid + 1;
         } else {
            right = mid - 1;
         }
      }

      return -1;
   }
}
