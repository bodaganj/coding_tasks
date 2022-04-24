package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

   public static void main(String[] args) {
      System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
   }

   private static List<Integer> countSmaller(int[] nums) {
      int[] ans = new int[nums.length];
      for (int i = nums.length - 2; i >= 0; i--) {
         int counter = 0;
         for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
               counter += ans[j];
               break;
            }
            if (nums[i] > nums[j]) {
               counter++;
            }
         }
         ans[i] = counter;
      }
      List<Integer> tmp = new ArrayList<>();
      for (int an : ans) {
         tmp.add(an);
      }

      return tmp;
   }
}
