package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.array_and_strings;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

   public static void main(String[] args) {
      System.out.println(findMissingRanges(new int[]{-1}, -2, -1));
      System.out.println(findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
   }

   private static List<String> findMissingRanges(int[] nums, int lower, int upper) {
      if (nums == null || nums.length == 0) {
         return List.of(getString(lower, upper));
      }

      List<String> ans = new ArrayList<>();

      if (nums[0] > lower) {
         ans.add(getString(lower, nums[0] - 1));
      }

      int prev = nums[0];
      for (int i = 1; i < nums.length; i++) {
         if ((nums[i] - prev) > 1) {
            ans.add(getString(prev + 1, nums[i] - 1));
         }
         prev = nums[i];
      }

      if (nums[nums.length - 1] < upper) {
         ans.add(getString(nums[nums.length - 1] + 1, upper));
      }

      return ans;
   }

   private static String getString(int left, int right) {
      StringBuilder sb = new StringBuilder();
      if (left == right) {
         sb.append(left);
      } else {
         sb.append(left).append("->").append(right);
      }
      return sb.toString();
   }
}
