package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.others;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

      Map<Integer, Integer> map = new LinkedHashMap<>();
      for (int[] building : buildings) {
         for (int j = building[0]; j <= building[1]; j++) {
            map.put(j, Math.max(map.getOrDefault(j, 0), building[2]));
         }
      }

      int currentValue = 0;
      int prevIndex = 0;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         if (prevIndex != 0 && entry.getKey() - 1 != prevIndex) {
            currentValue = 0;
            list.add(List.of(prevIndex, currentValue));

            currentValue = entry.getValue();
            list.add(List.of(entry.getKey(), currentValue));
            prevIndex = entry.getKey();
         } else if (entry.getValue() > currentValue) {
            currentValue = entry.getValue();
            list.add(List.of(entry.getKey(), currentValue));
            prevIndex = entry.getKey();
         } else if (entry.getValue() < currentValue) {
            currentValue = entry.getValue();
            list.add(List.of(entry.getKey() - 1, currentValue));
            prevIndex = entry.getKey();
         } else {
            prevIndex++;
         }
      }
      list.add(List.of(buildings[buildings.length - 1][1], 0));

      return list;
   }
}
