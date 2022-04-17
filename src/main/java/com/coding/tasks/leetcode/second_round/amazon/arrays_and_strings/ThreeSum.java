package com.coding.tasks.leetcode.second_round.amazon.arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

   public static void main(String[] args) {
      int[] array = new int[]{-1, 0, 1, 2, -1, -4};
      System.out.println(threeSum(array));
   }

   private static List<List<Integer>> threeSum(int[] nums) {
      Set<List<Integer>> list = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
         Map<Integer, Integer> map = new HashMap<>();
         for (int j = i + 1; j < nums.length; j++) {
            if (map.containsKey(nums[j])) {
               List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[map.get(nums[j])]);
               Collections.sort(tmp);
               list.add(tmp);
               map.remove(nums[j]);
            } else {
               map.put(-(nums[i] + nums[j]), j);
            }
         }
      }

      return new ArrayList<>(list);
   }
}
