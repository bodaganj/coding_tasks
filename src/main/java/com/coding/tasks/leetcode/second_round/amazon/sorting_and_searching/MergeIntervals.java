package com.coding.tasks.leetcode.second_round.amazon.sorting_and_searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {

   public static void main(String[] args) {
      System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
   }

   private static int[][] merge(int[][] intervals) {
      Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

      LinkedList<int[]> list = new LinkedList<>();
      for (int[] interval : intervals) {
         if (list.isEmpty() || list.getLast()[1] < interval[0]) {
            list.add(interval);
         } else {
            list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
         }
      }

      int[][] ans = new int[list.size()][2];
      for (int i = 0; i < list.size(); i++) {
         ans[i] = list.get(i);
      }

      return ans;
   }
}
