package com.coding.tasks.leetcode.top.interview.questions.medium.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

   public static void main(String[] args) {
      System.out.println(permute(new int[]{1, 2, 3}));
   }

   private static List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> total = new ArrayList<>();
      rec(nums, new HashSet<>(), new ArrayList<>(), total);
      return total;
   }

   private static void rec(int[] nums, Set<Integer> usedIndexes, List<Integer> current, List<List<Integer>> total) {
      if (current.size() == nums.length) {
         total.add(current);
         return;
      }

      for (int i = 0; i < nums.length; i++) {
         if (!usedIndexes.contains(i)) {
            Set<Integer> newSet = new HashSet<>(usedIndexes);
            newSet.add(i);

            List<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(nums[i]);

            rec(nums, newSet, newCurrent, total);
         }
      }
   }
}
