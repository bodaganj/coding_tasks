package com.coding.tasks.leetcode.third_round.fb.sorting.searching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {

  public int[] intersection(int[] nums1, int[] nums2) {
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for (int i : nums1) {
      set.add(i);
    }

    for (int i : nums2) {
      if (set.contains(i)) {
        list.add(i);
        set.remove(i);
      }
    }
    return list.stream().mapToInt(i->i).toArray();
  }
}
