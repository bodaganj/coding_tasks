package com.coding.tasks.leetcode.third_round.amazon.trees.and.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CutOffTreesForGolfEvent {

   private static int min = Integer.MAX_VALUE;
   private static int[][] matrix;
   private static int treesCount;
   private static int[][] dirs = new int[][]{
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1}
   };

   public static void main(String[] args) {
      System.out.println(cutOffTree(List.of(List.of(1, 2, 3), List.of(0, 0, 4), List.of(8, 7, 6))));
      System.out.println(cutOffTree(List.of(List.of(2, 3, 4), List.of(0, 0, 5), List.of(8, 7, 6))));
   }

   public static int cutOffTree(List<List<Integer>> forest) {
      if (forest.get(0).get(0) == 0) {
         return -1;
      }
      min = Integer.MAX_VALUE;
      matrix = new int[forest.size()][forest.get(0).size()];
      for (int i = 0; i < forest.size(); i++) {
         for (int j = 0; j < forest.get(i).size(); j++) {
            matrix[i][j] = forest.get(i).get(j);
         }
      }
      treesCount = getTreesAmount();

      dfs(0, 0, 0, new HashSet<>());
      return min == Integer.MAX_VALUE ? -1 : min;
   }

   private static void dfs(int x, int y, int count, Set<Pair> seen) {
      if (count == treesCount) {
         min = Math.min(min, count);
      } else {
         Pair pair = new Pair(x, y);
         seen.add(pair);
         List<List<Integer>> potentialMoves = getPotentialMoves(x, y, seen);
         for (List<Integer> potentialMove : potentialMoves) {
            dfs(potentialMove.get(0), potentialMove.get(1), count + 1, seen);
         }
         seen.remove(pair);
      }
   }

   private static int getTreesAmount() {
      int count = 0;
      for (int[] ints : matrix) {
         for (int j = 0; j < matrix[0].length; j++) {
            if (ints[j] > 1) {
               count++;
            }
         }
      }
      return matrix[0][0] > 1 ? count - 1 : count;
   }

   private static List<List<Integer>> getPotentialMoves(int x, int y, Set<Pair> seen) {
      // return all cells which are greater than current
      List<List<Integer>> ans = new ArrayList<>();
      for (int[] dir : dirs) {
         int i = x + dir[0];
         int j = y + dir[1];
         if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && !seen.contains(new Pair(i, j))
            && (matrix[i][j] == 1 || matrix[i][j] > matrix[x][y])) {
            ans.add(List.of(i, j));
         }
      }

      return ans;
   }

   private record Pair(int x, int y) {

   }
}
