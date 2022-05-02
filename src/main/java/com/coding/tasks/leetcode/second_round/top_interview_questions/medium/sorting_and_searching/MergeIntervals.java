package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.sorting_and_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

   public static void main(String[] args) {
      System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
      System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}})));
      System.out.println(Arrays.deepToString(merge(new int[][]{{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}})));
   }

   private static int[][] merge(int[][] intervals) {
      Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

      List<int[]> ans = new ArrayList<>();
      for (int[] interval : intervals) {
         if (!ans.isEmpty() && ans.get(ans.size() - 1)[1] >= interval[0]) {
            ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
         } else {
            ans.add(interval);
         }
      }

      int[][] result = new int[ans.size()][2];
      for (int i = 0; i < ans.size(); i++) {
         result[i] = ans.get(i);
      }
      return result;
   }
}
