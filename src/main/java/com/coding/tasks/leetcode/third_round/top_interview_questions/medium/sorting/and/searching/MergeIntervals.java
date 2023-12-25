package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.sorting.and.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

   public int[][] merge(int[][] intervals) {
      if (intervals.length == 1) {
         return intervals;
      }
      Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
      List<List<Integer>> ans = new ArrayList<>();
      int start = intervals[0][0];
      int finish = intervals[0][1];
      for (int i = 1; i < intervals.length; i++) {
         if (intervals[i][0] <= finish) {
            finish = Math.max(finish, intervals[i][1]);
         } else {
            ans.add(List.of(start, finish));
            start = intervals[i][0];
            finish = intervals[i][1];
         }
      }
      ans.add(List.of(start, finish));
      int[][] tmp = new int[ans.size()][2];
      for (int i = 0; i < ans.size(); i++) {
         tmp[i][0] = ans.get(i).get(0);
         tmp[i][1] = ans.get(i).get(1);
      }
      return tmp;
   }
}
