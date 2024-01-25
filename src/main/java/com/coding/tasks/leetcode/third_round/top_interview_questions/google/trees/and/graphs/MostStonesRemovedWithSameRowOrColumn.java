package com.coding.tasks.leetcode.third_round.top_interview_questions.google.trees.and.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {

   public static void main(String[] args) {
      System.out.println(removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
   }

   public static int removeStones(int[][] stones) {
      // find amount of connected trees + 1
      int count = 0;
      Set<Point> seen = new HashSet<>();
      Map<Integer, List<Point>> allRows = new HashMap<>();
      Map<Integer, List<Point>> allCols = new HashMap<>();
      for (int[] stone : stones) {
         if (!allRows.containsKey(stone[0])) {
            allRows.put(stone[0], new ArrayList<>());
         }
         allRows.get(stone[0]).add(new Point(stone[0], stone[1]));

         if (!allCols.containsKey(stone[1])) {
            allCols.put(stone[1], new ArrayList<>());
         }
         allCols.get(stone[1]).add(new Point(stone[0], stone[1]));
      }

      for (int[] stone : stones) {
         if (!seen.contains(new Point(stone[0], stone[1]))) {
            count++;
            seen.add(new Point(stone[0], stone[1]));

            Set<Integer> seenRows = new HashSet<>();
            Queue<Integer> rowsQueue = new LinkedList<>();
            rowsQueue.add(stone[0]);

            Set<Integer> seenCols = new HashSet<>();
            Queue<Integer> colsQueue = new LinkedList<>();
            colsQueue.add(stone[1]);

            while (!rowsQueue.isEmpty() || !colsQueue.isEmpty()) {
               Integer currRow = rowsQueue.poll();
               if (currRow != null) {
                  seenRows.add(currRow);
                  for (Point point : allRows.get(currRow)) {
                     seen.add(point);
                     if (!seenCols.contains(point.col)) {
                        colsQueue.add(point.col);
                     }
                  }
               }

               Integer currCol = colsQueue.poll();
               if (currCol != null) {
                  seenCols.add(currCol);
                  for (Point point : allCols.get(currCol)) {
                     seen.add(point);
                     if (!seenRows.contains(point.row)) {
                        rowsQueue.add(point.row);
                     }
                  }
               }
            }
         }
      }

      return stones.length - count;
   }

   private record Point(int row, int col) {

   }
}
