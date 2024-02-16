package com.coding.tasks.leetcode.third_round.apple.arrays.and.strings;

import java.util.*;

public class FourSum {

  public static void main(String[] args) {
    System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
  }

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    Set<List<Integer>> set = new HashSet<>();
    Map<Integer, List<List<Integer>>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (map.containsKey(target - nums[i] - nums[j])) {
          List<List<Integer>> indices = map.get(target - nums[i] - nums[j]);
          for (List<Integer> index : indices) {
            if (i != index.get(0) && i != index.get(1) && j != index.get(0) && j != index.get(1)) {
              List<Integer> tmp = new ArrayList<>();
              tmp.add(nums[i]);
              tmp.add(nums[j]);
              tmp.add(nums[index.get(0)]);
              tmp.add(nums[index.get(1)]);
              Collections.sort(tmp);
              set.add(tmp);
            }
          }
        }

        if (!map.containsKey(nums[i] + nums[j])) {
          map.put(nums[i] + nums[j], new ArrayList<>());
        }
        map.get(nums[i] + nums[j]).add(List.of(i, j));
      }
    }
    return new ArrayList<>(set);
  }
}
