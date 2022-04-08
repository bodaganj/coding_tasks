package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.sorting_and_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

   public static void main(String[] args) {
      System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
      System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}})));
   }

   private static int[][] merge(int[][] intervals) {
      if (intervals.length == 1) {
         return intervals;
      }
      // sort
      Arrays.sort(intervals, Comparator.comparingDouble(a -> a[0]));

      // merge
      List<List<Integer>> ans = new ArrayList<>();
      int currentStart = intervals[0][0];
      int currentFinish = intervals[0][1];
      for (int i = 1; i < intervals.length; i++) {
         if (currentFinish < intervals[i][0]) {
            ans.add(List.of(currentStart, currentFinish));
            currentStart = intervals[i][0];
            currentFinish = intervals[i][1];
         } else if (currentFinish < intervals[i][1]) {
            currentFinish = intervals[i][1];
         }
         if (i == intervals.length - 1) {
            ans.add(List.of(currentStart, currentFinish));
         }
      }

      int[][] res = new int[ans.size()][2];
      for (int i = 0; i < ans.size(); i++) {
         res[i][0] = ans.get(i).get(0);
         res[i][1] = ans.get(i).get(1);
      }

      return res;
   }
}
