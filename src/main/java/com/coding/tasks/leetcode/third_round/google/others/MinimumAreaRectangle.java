package com.coding.tasks.leetcode.third_round.google.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MinimumAreaRectangle {

   public static void main(String[] args) {
      System.out.println(minAreaRect(new int[][]{
         {1, 1},
         {1, 3},
         {3, 1},
         {3, 3},
         {4, 1},
         {4, 3},
      }));
   }

   public static int minAreaRect(int[][] points) {
      int area = Integer.MAX_VALUE;

      Map<Integer, List<Integer>> rows = new HashMap<>();
      Map<Integer, List<Integer>> cols = new HashMap<>();
      for (int[] point : points) {
         if (!rows.containsKey(point[0])) {
            rows.put(point[0], new ArrayList<>());
         }
         rows.get(point[0]).add(point[1]);

         if (!cols.containsKey(point[1])) {
            cols.put(point[1], new ArrayList<>());
         }
         cols.get(point[1]).add(point[0]);
      }

      Set<Integer> seenRows = new HashSet<>();
      for (Map.Entry<Integer, List<Integer>> entry : rows.entrySet()) {
         List<Integer> columns = entry.getValue();
         if (columns.size() == 1) {
            continue;
         }
         for (int i = 0; i < columns.size(); i++) {
            for (int j = i + 1; j < columns.size(); j++) {
               List<Integer> rows1 = cols.get(columns.get(i));
               List<Integer> rows2 = cols.get(columns.get(j));
               List<Integer> common = getCommon(rows1, rows2, entry.getKey());
               for (int com : common) {
                  if (!seenRows.contains(com)) {
                     area = Math.min(area, Math.abs(columns.get(j) - columns.get(i)) * Math.abs(entry.getKey() - com));
                  }
               }
            }
         }
         seenRows.add(entry.getKey());
      }

      return area == Integer.MAX_VALUE ? 0 : area;
   }

   private static List<Integer> getCommon(List<Integer> rows1, List<Integer> rows2, int except) {
      List<Integer> common = new ArrayList<>();
      for (Integer integer : rows1) {
         for (Integer value : rows2) {
            if (Objects.equals(integer, value)) {
               if (integer != except) {
                  common.add(integer);
               }
            }
         }
      }
      return common;
   }
}
