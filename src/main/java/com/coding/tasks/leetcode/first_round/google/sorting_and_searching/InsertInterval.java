package com.coding.tasks.leetcode.first_round.google.sorting_and_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

   public static void main(String[] args) {
      System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
//      System.out.println(Arrays.deepToString(insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
//      System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{6, 8})));
   }

   private static int[][] insert(int[][] intervals, int[] newInterval) {
      if (intervals == null || intervals.length == 0) {
         return new int[][]{newInterval};
      }

      List<int[]> list = new ArrayList<>();
      if (intervals[0][0] > newInterval[1]) {
         list.add(newInterval);
      }

      int start = newInterval[0];
      int end = newInterval[1];
      boolean toProcess = false;
      boolean isAdded = false;

      for (int[] interval : intervals) {
         if (isAdded) {
            list.add(interval);
         } else {
            if (interval[0] > newInterval[1] && !isAdded) {
               list.add(newInterval);
               list.add(interval);
               isAdded = true;
            }
            if (interval[0] <= end && interval[1] >= start) {
               start = Math.min(start, interval[0]);
               end = Math.max(end, interval[1]);
               toProcess = true;
            } else {
               if (toProcess) {
                  list.add(new int[]{start, end});
                  isAdded = true;
                  toProcess = false;
               }
               list.add(interval);
            }
         }
      }

      if (intervals[intervals.length - 1][1] < newInterval[0]) {
         list.add(newInterval);
      }

      if (toProcess) {
         list.add(new int[]{start, end});
      }

      int[][] ans = new int[list.size()][2];
      return list.toArray(ans);
   }
}
