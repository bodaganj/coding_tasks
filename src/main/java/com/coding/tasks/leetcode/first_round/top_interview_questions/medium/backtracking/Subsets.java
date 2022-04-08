package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

   public static void main(String[] args) {
      System.out.println(subsets(new int[]{1, 2, 3}));
   }

   private static List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      ans.add(Collections.emptyList());

      for (int num : nums) {
         int size = ans.size();
         int counter = 0;
         while (size-- > 0) {
            List<Integer> tmp = new ArrayList<>(ans.get(counter));
            tmp.add(num);
            ans.add(tmp);

            counter++;
         }
      }
      return ans;
   }
}
