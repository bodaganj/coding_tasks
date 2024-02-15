package com.coding.tasks.leetcode.third_round.fb.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntervalListIntersections {

  public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    if (firstList.length == 0 || secondList.length == 0) {
      return new int[][]{};
    }

    List<List<Integer>> ans = new ArrayList<>();
    int first = 0;
    int second = 0;
    while (first < firstList.length && second < secondList.length) {
      int firstStart = firstList[first][0];
      int firstEnd = firstList[first][1];
      int secondStart = secondList[second][0];
      int secondEnd = secondList[second][1];
      if (firstStart > secondEnd) {
        second++;
      } else if (firstEnd < secondStart) {
        first++;
      } else {
        ans.add(List.of(Math.max(firstStart, secondStart), Math.min(firstEnd, secondEnd)));
        if (firstEnd < secondEnd) {
          first++;
        } else {
          second++;
        }
      }
    }

    int[][] ret = new int[ans.size()][2];
    for (int i = 0; i < ans.size(); i++) {
      ret[i] = ans.get(i).stream().mapToInt(in -> in).toArray();
    }
    return ret;
  }
}
