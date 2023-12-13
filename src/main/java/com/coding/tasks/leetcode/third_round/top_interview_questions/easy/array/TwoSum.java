package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

   public static void main(String[] args) {

   }

   public static int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> missingValue = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
         if (missingValue.containsKey(target - nums[i])) {
            return new int[]{i, missingValue.get(target - nums[i])};
         } else {
            missingValue.put(nums[i], i);
         }
      }
      return null;
   }
}
