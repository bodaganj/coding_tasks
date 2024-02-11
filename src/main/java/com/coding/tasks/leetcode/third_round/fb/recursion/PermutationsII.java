package com.coding.tasks.leetcode.third_round.fb.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {

  public static void main(String[] args) {
    System.out.println(permuteUnique(new int[]{1, 2, 3}));
    System.out.println(permuteUnique(new int[]{1, 1, 2}));
  }

  public static List<List<Integer>> permuteUnique(int[] nums) {
    Set<List<Integer>> ans = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      List<Integer> list = new ArrayList<>();
      list.add(nums[i]);
      Set<Integer> indexes = new HashSet<>();
      indexes.add(i);
      rec(list, indexes, nums, ans);
    }
    return new ArrayList<>(ans);
  }

  private static void rec(List<Integer> current, Set<Integer> indexes, int[] nums, Set<List<Integer>> ans) {
    if (current.size() == nums.length) {
      ans.add(current);
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (!indexes.contains(i)) {
          List<Integer> newCurrent = new ArrayList<>(current);
          newCurrent.add(nums[i]);
          indexes.add(i);
          rec(newCurrent, indexes, nums, ans);
          indexes.remove(i);
        }
      }
    }
  }
}
