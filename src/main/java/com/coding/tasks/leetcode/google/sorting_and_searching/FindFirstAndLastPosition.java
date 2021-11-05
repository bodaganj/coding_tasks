package com.coding.tasks.leetcode.google.sorting_and_searching;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindFirstAndLastPosition {

   private static FindFirstAndLastPosition findFirstAndLastPosition = new FindFirstAndLastPosition();

   public static void main(String[] args) {
      int[] nums1 = new int[]{5, 7, 7, 8, 8, 10};
      int[] nums2 = new int[]{1, 2, 3};
      int[] indexes2 = findFirstAndLastPosition.searchRange(nums2, 3);
      int[] indexes1 = findFirstAndLastPosition.searchRange(nums1, 8);
      for (int index : indexes2) {
         System.out.print(index + " ");
      }
      System.out.println();
      for (int index : indexes1) {
         System.out.print(index + " ");
      }
   }

   public int[] searchRange(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
         return new int[]{-1, -1};
      }

      if (nums[0] > target || nums[nums.length - 1] < target) {
         return new int[]{-1, -1};
      }

      if (nums.length == 1) {
         if (nums[0] != target) {
            return new int[]{-1, -1};
         } else {
            return new int[]{0, 0};
         }
      }

      List<Integer> input = Arrays.stream(nums).boxed().collect(Collectors.toList());

      int initialMiddleValue = 0;
      while (input.size() >= 1) {
         int middle = input.size() / 2;
         Integer middleElement = input.get(middle);

         if (middleElement > target) {
            initialMiddleValue += middle;
            input = input.subList(0, middle);
         } else if (middleElement < target) {
            initialMiddleValue += middle;
            input = input.subList(middle, input.size());
         } else {
            int left = middle;
            int leftCounter = 0;
            while (middle - leftCounter >= 0 && input.get(middle - leftCounter) == target) {
               left = middle - leftCounter;
               leftCounter++;
            }

            int right = middle;
            int rightCounter = 0;
            while (middle + rightCounter < input.size() && input.get(middle + rightCounter) == target) {
               right = middle + rightCounter;
               rightCounter++;
            }

            return new int[]{left + initialMiddleValue, right + initialMiddleValue};
         }
      }
      return new int[]{-1, -1};
   }
}
