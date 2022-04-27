package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

   public static void main(String[] args) {
      System.out.println(subsets(new int[]{1, 2, 3}));
   }

   private static List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      ans.add(new ArrayList<>());

      for (int num : nums) {
         int i = 0;
         List<List<Integer>> newSubsets = new ArrayList<>();
         while (i < ans.size()) {
            List<Integer> tmp = new ArrayList<>(ans.get(i));
            tmp.add(num);
            newSubsets.add(tmp);
            i++;
         }
         ans.addAll(newSubsets);
      }

      return ans;
   }
}
