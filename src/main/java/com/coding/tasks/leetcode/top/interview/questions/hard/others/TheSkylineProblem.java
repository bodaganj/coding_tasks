package com.coding.tasks.leetcode.top.interview.questions.hard.others;

import java.util.ArrayList;
import java.util.List;

public class TheSkylineProblem {

   public static void main(String[] args) {
      System.out.println(getSkyline(new int[][]{
         {2, 9, 10},
         {3, 7, 15},
         {5, 12, 12},
         {15, 20, 10},
         {19, 24, 8}
      }));

      System.out.println(getSkyline(new int[][]{
         {0, 2147483647, 2147483647}
      }));
   }

   private static List<List<Integer>> getSkyline(int[][] buildings) {
      List<List<Integer>> list = new ArrayList<>();

      int maxX = 0;
      for (int[] building : buildings) {
         maxX = Math.max(maxX, building[1]);
      }

      int[] ans = new int[maxX + 2];
      for (int[] building : buildings) {
         for (int j = building[0]; j <= building[1]; j++) {
            ans[j] = Math.max(ans[j], building[2]);
         }
      }

      int currentValue = 0;
      for (int i = 0; i < ans.length; i++) {
         if (ans[i] > currentValue) {
            currentValue = ans[i];
            list.add(List.of(i, currentValue));
         } else if (ans[i] < currentValue) {
            currentValue = ans[i];
            list.add(List.of(i - 1, currentValue));
         }
      }

      return list;
   }
}
