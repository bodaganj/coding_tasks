package com.coding.tasks.cracking.the.code.recursion_and_dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsWithDuplicates {

   public static void main(String[] args) {
      System.out.println(permuteUnique(new int[]{1, 1, 2}));
   }

   private static List<List<Integer>> permuteUnique(int[] nums) {
      Set<List<Integer>> ans = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
         rec(nums, i, new ArrayList<>(), new HashSet<>(), ans);
      }

      return new ArrayList<>(ans);
   }

   private static void rec(int[] nums, int n, List<Integer> current, Set<Integer> used, Set<List<Integer>> ans) {
      List<Integer> tmp = new ArrayList<>(current);
      tmp.add(nums[n]);

      if (tmp.size() == nums.length) {
         ans.add(tmp);
         return;
      }

      Set<Integer> newSet = new HashSet<>(used);
      newSet.add(n);

      for (int i = 0; i < nums.length; i++) {
         if (!newSet.contains(i)) {
            rec(nums, i, tmp, newSet, ans);
         }
      }
   }
}
