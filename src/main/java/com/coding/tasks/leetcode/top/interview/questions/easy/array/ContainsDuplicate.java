package com.coding.tasks.leetcode.top.interview.questions.easy.array;

import java.util.Arrays;

public class ContainsDuplicate {

   private static boolean containsDuplicate(int[] nums) {
      return !(Arrays.stream(nums).distinct().count() == nums.length);
   }
}
