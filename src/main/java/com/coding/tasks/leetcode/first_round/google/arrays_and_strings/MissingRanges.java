package com.coding.tasks.leetcode.first_round.google.arrays_and_strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MissingRanges {

   public static void main(String[] args) {
      System.out.println(findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
      System.out.println(findMissingRanges(new int[]{}, 1, 1));
   }

   private static List<String> findMissingRanges(int[] nums, int lower, int upper) {
      if (nums.length == 0) {
         if (lower < upper) {
            return Collections.singletonList(lower + "->" + upper);
         } else {
            return Collections.singletonList(lower + "");
         }
      }
      if (lower == upper) {
         return Collections.emptyList();
      }

      List<String> finalList = new ArrayList<>();
      int start = nums[0];
      if (start > lower) {
         finalList.add(readyToAdd(lower, start - 1));
      }
      for (int i = 1; i < nums.length; i++) {
         if (nums[i] - start > 1) {
            finalList.add(readyToAdd(start + 1, nums[i] - 1));
         }
         start = nums[i];
      }
      if (nums[nums.length - 1] < upper) {
         finalList.add(readyToAdd(nums[nums.length - 1] + 1, upper));
      }
      return finalList;
   }

   private static String readyToAdd(int start, int finish) {
      if (Objects.equals(start, finish)) {
         return String.valueOf(start);
      } else {
         return start + "->" + finish;
      }
   }
}
