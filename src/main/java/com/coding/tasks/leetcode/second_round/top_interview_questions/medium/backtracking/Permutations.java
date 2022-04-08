package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.backtracking;

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
   }
}
