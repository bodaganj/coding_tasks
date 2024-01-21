package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.trees.and.graphs;

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
            dfs(i, j, memo);
         }
      }
      return max;
   }

   private static int dfs(int i, int j, int[][] memo) {
      if (memo[i][j] > 0) {
         return memo[i][j];
      }
      int currMax = 1;
      for (int[] ints : dir) {
         int x = i + ints[0];
         int y = j + ints[1];
         if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] > board[i][j]) {
            int dfs = 1 + dfs(x, y, memo);
            currMax = Math.max(currMax, dfs);
         }
      }
      max = Math.max(max, currMax);
      memo[i][j] = currMax;
      return memo[i][j];
   }
}
