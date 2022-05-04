package com.coding.tasks.leetcode.second_round.google.sorting_and_searching;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

   public static void main(String[] args) {
      System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
   }

   private static List<Integer> countSmaller(int[] nums) {
      List<Integer> ans = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
         int counter = 0;
         for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] > nums[j]) {
               counter++;
            }
         }
         ans.add(counter);
      }

      return ans;
   }
}
