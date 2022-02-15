package com.coding.tasks.cracking.the.code.recursion_and_dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

   public static void main(String[] args) {
      System.out.println(permute(new int[]{1, 2, 3}));
   }

   private static List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      for (int num : nums) {
         rec(nums, num, new ArrayList<>(), new HashSet<>(), ans);
      }

      return ans;
   }

   private static void rec(int[] nums, int n, List<Integer> current, Set<Integer> used, List<List<Integer>> ans) {
      List<Integer> tmp = new ArrayList<>(current);
      tmp.add(n);

      if (tmp.size() == nums.length) {
         ans.add(tmp);
         return;
      }

      Set<Integer> newSet = new HashSet<>(used);
      newSet.add(n);

      for (int num : nums) {
         if (!newSet.contains(num)) {
            rec(nums, num, tmp, newSet, ans);
         }
      }
   }
}
