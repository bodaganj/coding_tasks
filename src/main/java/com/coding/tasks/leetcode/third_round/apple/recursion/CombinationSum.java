package com.coding.tasks.leetcode.third_round.apple.recursion;

import java.util.*;

public class CombinationSum {

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Set<List<Integer>> set = new HashSet<>();
    rec(target, candidates, new ArrayList<>(), set);
    return new ArrayList<>(set);
  }

  private static void rec(int target, int[] candidates, List<Integer> currentList, Set<List<Integer>> set) {
    int sum = currentList.stream().mapToInt(i -> i).sum();
    if (sum == target) {
      Collections.sort(currentList);
      set.add(currentList);
    } else {
      for (int candidate : candidates) {
        if (sum + candidate <= target) {
          List<Integer> tmp = new ArrayList<>(currentList);
          tmp.add(candidate);
          rec(target, candidates, tmp, set);
        }
      }
    }
  }
}
