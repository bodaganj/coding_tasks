package com.coding.tasks.leetcode.third_round.google.arrays.and.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSum {

   public static void main(String[] args) {
      System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
      System.out.println(threeSum(new int[]{0, 1, 1}));
      System.out.println(threeSum(new int[]{0, 0, 0}));
   }

   public static List<List<Integer>> threeSum(int[] nums) {
      Set<List<Integer>> ans = new HashSet<>();
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
         for (int j = i + 1; j < nums.length; j++) {
            if (set.contains((nums[i] + nums[j]) * -1)) {
               List<Integer> num = List.of(nums[i], nums[j], (nums[i] + nums[j]) * -1);
               ans.add(num.stream().sorted().collect(Collectors.toList()));
            }
         }
         set.add(nums[i]);
      }
      return new ArrayList<>(ans);
   }
}
