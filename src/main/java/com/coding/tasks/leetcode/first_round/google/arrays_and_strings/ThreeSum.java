package com.coding.tasks.leetcode.first_round.google.arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ThreeSum {

   public static void main(String[] args) {
      List<Integer> set1 = List.of(1, 0);
      List<Integer> set2 = List.of(0, 1);

      Set<List<Integer>> set = new HashSet<>();
      set.add(set1);
      set.add(set2);
      System.out.println(set.size());

      System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
   }

   private static List<List<Integer>> threeSum(int[] nums) {
      if (Objects.isNull(nums) || nums.length < 3) {
         return Collections.emptyList();
      }

      Set<List<Integer>> result = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
         Map<Integer, Integer> map = new HashMap<>();
         int j = i + 1;
         while (j < nums.length) {
            if (map.containsKey(nums[j])) {
               List<Integer> tmpList = Arrays.asList(nums[i], nums[j], nums[map.get(nums[j])]);
               Collections.sort(tmpList);
               result.add(tmpList);
            } else {
               map.put(-(nums[i] + nums[j]), j);
            }
            j++;
         }
      }
      return new ArrayList<>(result);
   }
}
