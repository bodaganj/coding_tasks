package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.array_and_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
      for (int i = 0; i < nums.length; i++) {
         Map<Integer, Integer> map = new HashMap<>();
         for (int j = i + 1; j < nums.length; j++) {
            int expected = (nums[i] + nums[j]) * -1;
            if (map.containsKey(nums[j])) {
               ans.add(Stream.of(nums[i], nums[j], nums[map.get(nums[j])]).sorted().collect(Collectors.toList()));
               map.remove(nums[j]);
            } else {
               map.put(expected, j);
            }
         }
      }
      return new ArrayList<>(ans);
   }
}
