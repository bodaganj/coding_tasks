package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.array_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ThreeSum {

   public static void main(String[] args) {
      int[] array = new int[]{-1, 0, 1, 2, -1, -4};
      System.out.println(threeSum(array));
   }

   private static List<List<Integer>> threeSum(int[] nums) {
      if (Objects.isNull(nums) || nums.length < 3) {
         return Collections.emptyList();
      }
      Arrays.sort(nums); // O(n log n)

      Set<List<Integer>> finalResult = new HashSet<>();

      for (int i = 0; i < nums.length - 2; i++) { // O(n)
         if (nums[i] > 0 || (i > 1 && nums[i - 1] == nums[i])) {
            continue;
         }
         Set<Integer> set = new HashSet<>();
         for (int j = i + 1; j < nums.length; j++) { // O(n)
            int expected = -(nums[i] + nums[j]);
            if (set.contains(expected)) { // O(1)
               finalResult.add(List.of(nums[i], nums[j], expected));
            } else {
               set.add(nums[j]);
            }
         }
      }
      return new ArrayList<>(finalResult);
   }
}
