package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.array_and_strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingRanges {

   public static void main(String[] args) {
      System.out.println(findMissingRanges(new int[]{-1}, -2, -1));
      System.out.println(findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
   }

   private static List<String> findMissingRanges(int[] nums, int lower, int upper) {
      if (nums.length == 0) {
         return Collections.singletonList(getRange(lower, upper));
      }

      List<String> list = new ArrayList<>();
      if (nums[0] != lower) {
         list.add(getRange(lower, nums[0] - 1));
      }

      for (int i = 1; i < nums.length; i++) {
         if (nums[i] - nums[i - 1] != 1) {
            list.add(getRange(nums[i - 1] + 1, nums[i] - 1));
         }
      }

      if (nums[nums.length - 1] != upper) {
         list.add(getRange(nums[nums.length - 1] + 1, upper));
      }
      return list;
   }

   private static String getRange(int start, int end) {
      return start == end ? String.valueOf(start) : start + "->" + end;
   }
}
