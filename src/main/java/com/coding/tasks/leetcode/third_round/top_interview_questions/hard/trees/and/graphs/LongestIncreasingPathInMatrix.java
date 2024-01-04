package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.trees.and.graphs;

import java.util.HashSet;
import java.util.Set;

public class LongestIncreasingPathInMatrix {

   private static final int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
   private static int max;
   private static int[][] board;

   public static void main(String[] args) {
      System.out.println(longestIncreasingPath(new int[][]{
         {9, 9, 4},
         {6, 6, 8},
         {2, 1, 1}}));
   }

   public static int longestIncreasingPath(int[][] matrix) {
      max = Integer.MIN_VALUE;
      board = matrix;
      int[][] memo = new int[matrix.length][matrix[0].length];
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[0].length; j++) {
            Set<Pair> set = new HashSet<>();
            set.add(new Pair(i, j));
            dfs(i, j, set, memo);
         }
      }
      return max;
   }

   private static int dfs(int i, int j, Set<Pair> seen, int[][] memo) {
      if (memo[i][j] > 0) {
         return memo[i][j];
      }
      int currMax = 1;
      for (int[] ints : dir) {
         seen.add(new Pair(i, j));
         int x = i + ints[0];
         int y = j + ints[1];
         if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] > board[i][j] && !seen.contains(new Pair(x, y))) {
            int dfs = 1 + dfs(x, y, new HashSet<>(seen), memo);
            currMax = Math.max(currMax, dfs);
         }
      }
      max = Math.max(max, currMax);
      memo[i][j] = currMax;
      return memo[i][j];
   }

   public record Pair(int x, int y) {

   }
}
