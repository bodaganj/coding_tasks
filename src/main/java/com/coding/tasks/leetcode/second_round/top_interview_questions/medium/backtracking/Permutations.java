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
      rec(new ArrayList<>(), nums, new HashSet<>(), total);
      return total;
   }

   private static void rec(List<Integer> current, int[] nums, Set<Integer> used, List<List<Integer>> total) {
      if (current.size() == nums.length) {
         total.add(current);
      } else {
         for (int num : nums) {
            if (!used.contains(num)) {
               Set<Integer> newUsed = new HashSet<>(used);
               newUsed.add(num);

               List<Integer> tmp = new ArrayList<>(current);
               tmp.add(num);

               rec(tmp, nums, newUsed, total);
            }
         }
      }
   }
}
