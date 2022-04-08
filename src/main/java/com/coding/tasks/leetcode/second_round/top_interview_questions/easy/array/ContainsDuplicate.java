package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.array;

import java.util.Arrays;

public class ContainsDuplicate {

   private static boolean containsDuplicate(int[] nums) {
      return !(Arrays.stream(nums).distinct().count() == nums.length);
   }
}
