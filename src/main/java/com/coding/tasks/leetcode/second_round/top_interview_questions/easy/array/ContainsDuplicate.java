package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

   private static boolean containsDuplicate(int[] nums) {
      Set<Integer> set = new HashSet<>();

      for (int num : nums) {
         if (!set.add(num)) {
            return true;
         }
      }

      return false;
   }
}
