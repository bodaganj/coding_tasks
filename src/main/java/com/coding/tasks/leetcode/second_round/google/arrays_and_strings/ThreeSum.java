package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSum {

   public static void main(String[] args) {
      System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
   }

   private static List<List<Integer>> threeSum(int[] nums) {
      Set<List<Integer>> ans = new HashSet<>();
      Map<Integer, Set<Integer>> mapping = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
         Set<Integer> value = mapping.getOrDefault(nums[i], new HashSet<>());
         value.add(i);
         mapping.put(nums[i], value);
      }

      Set<Integer> visited = new HashSet<>();
      for (int i = 0; i < nums.length - 1; i++) {
         for (int j = i + 1; j < nums.length; j++) {
            int expectedValue = -1 * (nums[i] + nums[j]);

            visited.add(expectedValue);
            int ii = i;
            int jj = j;
            if (mapping.containsKey(expectedValue)) {
               List<Integer> integers = mapping.get(expectedValue).stream().filter(v -> v != ii && v != jj).collect(Collectors.toList());
               if (!integers.isEmpty()) {
                  List<Integer> tmp = new ArrayList<>();
                  tmp.add(nums[i]);
                  tmp.add(nums[j]);
                  tmp.add(nums[integers.get(0)]);
                  Collections.sort(tmp);
                  ans.add(tmp);
               }
            }
         }
      }

      return new ArrayList<>(ans);
   }
}
