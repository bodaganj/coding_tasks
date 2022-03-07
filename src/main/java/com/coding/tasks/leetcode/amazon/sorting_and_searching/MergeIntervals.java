package com.coding.tasks.leetcode.amazon.sorting_and_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

   public static void main(String[] args) {

   }

   private static int[][] merge(int[][] intervals) {
      if (intervals.length == 1) {
         return intervals;
      }
      Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

      int start = intervals[0][0];
      int end = intervals[0][1];
      List<int[]> ans = new ArrayList<>();

      for (int i = 1; i < intervals.length; i++) {
         if (end < intervals[i][0]) {
            ans.add(new int[]{start, end});
            start = intervals[i][0];
         }
         end = Math.max(end, intervals[i][1]);

         if (i == intervals.length - 1) {
            ans.add(new int[]{start, end});
         }
      }

      int[][] res = new int[ans.size()][2];
      return ans.toArray(res);
   }
}
