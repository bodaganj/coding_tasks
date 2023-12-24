package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

   public static void main(String[] args) {
      System.out.println(permute(new int[]{1, 2, 3}));
   }

   public static List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      rec(Arrays.stream(nums).boxed().collect(Collectors.toList()), new ArrayList<>(), ans);
      return ans;
   }

   private static void rec(List<Integer> left, List<Integer> curr, List<List<Integer>> ans) {
      if (left.isEmpty()) {
         ans.add(curr);
      } else {
         for (int i = 0; i < left.size(); i++) {
            Integer elem = left.get(i);
            List<Integer> newCur = new ArrayList<>(curr);
            newCur.add(elem);
            List<Integer> newLeft = new ArrayList<>(left);
            newLeft.remove(elem);

            rec(newLeft, newCur, ans);
         }
      }
   }
}
