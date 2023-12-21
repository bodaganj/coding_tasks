package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.array.and.string;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

   public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
      if (nums.length == 0) {
         return List.of(List.of(lower, upper));
      }
      List<List<Integer>> ans = new ArrayList<>();
      if (nums[0] > lower) {
         ans.add(List.of(lower, nums[0] - 1));
      }

      for (int i = 0; i < nums.length - 1; i++) {
         int curr = nums[i];
         int next = nums[i + 1];

         if (curr + 1 < next) {
            ans.add(List.of(curr + 1, next - 1));
         }
      }

      if (nums[nums.length - 1] < upper) {
         ans.add(List.of(nums[nums.length - 1] + 1, upper));
      }
      return ans;
   }
}
