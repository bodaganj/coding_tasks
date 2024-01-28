package com.coding.tasks.leetcode.third_round.google.sorting.and.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertInterval {

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{2, 3})));
    System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{8, 9})));
    System.out.println(Arrays.deepToString(insert(new int[][]{{1, 4}, {9, 12}, {19, 22}}, new int[]{7, 13})));
    System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{4, 4})));
    System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{3, 6})));
    System.out.println(Arrays.deepToString(insert(new int[][]{{0, 2}, {3, 3}, {6, 11}}, new int[]{9, 15})));
    System.out.println(Arrays.deepToString(insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
  }

  public static int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals.length == 0) {
      return new int[][]{newInterval};
    }
    List<int[]> ans = new ArrayList<>();
    if (newInterval[1] < intervals[0][0]) {
      ans.add(newInterval);
      Collections.addAll(ans, intervals);
    } else if (newInterval[0] > intervals[intervals.length - 1][1]) {
      Collections.addAll(ans, intervals);
      ans.add(newInterval);
    } else {
      int start = Math.min(intervals[0][0], newInterval[0]);
      int finish = intervals[0][1];
      boolean added = false;
      for (int[] currInterval : intervals) {
        if (!added) {
          if (newInterval[0] >= start && newInterval[0] <= finish) {
            finish = Math.max(finish, newInterval[1]);
            added = true;
          }
        }
        if (currInterval[0] > finish) {
          ans.add(new int[]{start, finish});
          start = currInterval[0];
          finish = currInterval[1];
          if (!added) {
            if (newInterval[1] < start) {
              ans.add(newInterval);
              added = true;
            } else if (newInterval[0] < finish) {
              start = Math.min(start, newInterval[0]);
              finish = Math.max(currInterval[1], newInterval[1]);
              added = true;
            }
          }
        } else {
          finish = Math.max(finish, currInterval[1]);
        }
      }

      if (!added) {
        start = Math.min(start, newInterval[0]);
        finish = Math.max(finish, newInterval[1]);
      }
      ans.add(new int[]{start, finish});
    }

    int[][] ret = new int[ans.size()][2];
    for (int i = 0; i < ans.size(); i++) {
      ret[i] = ans.get(i);
    }
    return ret;
  }
}
