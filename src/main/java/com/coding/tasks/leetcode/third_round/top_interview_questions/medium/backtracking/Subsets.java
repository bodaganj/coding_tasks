package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

   public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      ans.add(Collections.emptyList());
      rec(nums, 0, ans);
      return ans;
   }

   private void rec(int[] nums, int index, List<List<Integer>> ans) {
      if (index == nums.length) {
         return;
      }
      List<List<Integer>> tmp = new ArrayList<>();
      for (List<Integer> an : ans) {
         List<Integer> aa = new ArrayList<>(an);
         aa.add(nums[index]);
         tmp.add(aa);
      }
      ans.addAll(tmp);
      rec(nums, index + 1, ans);
   }
}
