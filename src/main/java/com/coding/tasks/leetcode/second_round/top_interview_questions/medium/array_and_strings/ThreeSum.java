package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.array_and_strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSum {

   public static void main(String[] args) {
      int[] array = new int[]{-1, 0, 1, 2, -1, -4};
      System.out.println(threeSum(array));
   }

   private static List<List<Integer>> threeSum(int[] nums) {
      Set<List<Integer>> ans = new HashSet<>();
      for (int i = 0; i < nums.length - 2; i++) { // O(n)
         Set<Integer> mapping = new HashSet<>();
         for (int j = i + 1; j < nums.length; j++) { // O(n)
            if (mapping.contains(nums[j])) {
               List<Integer> collect = Stream.of(nums[i], nums[j], (nums[i] + nums[j]) * -1).sorted().collect(Collectors.toList());
               ans.add(collect);
               mapping.remove(nums[j]);
            } else {
               mapping.add(nums[i] * -1 - nums[j]);
            }
         }
      }

      return new ArrayList<>(ans);
   }
}
