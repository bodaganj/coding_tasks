package com.coding.tasks.leetcode.google.sorting_and_searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

   public static void main(String[] args) {

   }

   private static List<Integer> countSmaller(int[] nums) {
      List<Integer> ans = new ArrayList<>();

      int i = nums.length - 2;
      ans.add(0);

      while (i >= 0) {
         int j = nums.length - 1;
         int counter = 0;
         while (j > i) {
            if (nums[j] < nums[i]) {
               counter++;
            }
            j--;
         }
         ans.add(counter);
         i--;
      }

      Collections.reverse(ans);
      return ans;
   }
}
