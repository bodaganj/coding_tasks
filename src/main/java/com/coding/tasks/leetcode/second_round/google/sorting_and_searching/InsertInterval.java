package com.coding.tasks.leetcode.second_round.google.sorting_and_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

   public static void main(String[] args) {
      System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
      System.out.println(Arrays.deepToString(insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
      System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{6, 8})));
      System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{2, 3})));
      System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{0, 3})));
      System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{0, 0})));
   }

//   private static List<int[]> mergeIntervals(List<int[]> ans) {
//      List<int[]> tmp = new ArrayList<>();
//      Queue<int[]> queue = new LinkedList<>();
//      queue.offer(ans.get(0));
//      for (int i = 1; i < ans.size(); i++) {
//         int[] poll = queue.poll();
//         if (poll[1] < ans.get(i)[0]) {
//            tmp.add(poll);
//            queue.offer(ans.get(i));
//         } else {
//            queue.offer(new int[]{poll[0], Math.max(poll[1], ans.get(i)[1])});
//         }
//      }
//
//      tmp.add(queue.poll());
//      return tmp;
//   }

   private static int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> ans = new ArrayList<>();
      boolean flag = true;
      for (int[] interval : intervals) {
         if (flag) {
            if (newInterval[1] < interval[0]) {
               ans.add(newInterval);
               ans.add(interval);
               flag = false;
            } else if (newInterval[0] < interval[1]) {
               ans.add(new int[]{Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])});
               flag = false;
            } else {
               ans.add(interval);
            }
         } else {
            ans.add(interval);
         }
      }

      if (flag) {
         ans.add(newInterval);
      }

      List<int[]> tmp = mergeIntervals(ans);
      int[][] res = new int[tmp.size()][2];
      for (int i = 0; i < tmp.size(); i++) {
         res[i][0] = tmp.get(i)[0];
         res[i][1] = tmp.get(i)[1];
      }
      return res;
   }

   private static List<int[]> mergeIntervals(List<int[]> ans) {
      List<int[]> tmp = new ArrayList<>();
      for (int[] interval : ans) {
         if (!tmp.isEmpty() && tmp.get(tmp.size() - 1)[1] >= interval[0]) {
            tmp.get(tmp.size() - 1)[1] = Math.max(tmp.get(tmp.size() - 1)[1], interval[1]);
         } else {
            tmp.add(interval);
         }
      }
      return tmp;
   }
}
