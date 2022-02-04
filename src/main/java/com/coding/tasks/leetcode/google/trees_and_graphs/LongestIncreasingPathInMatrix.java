package com.coding.tasks.leetcode.google.trees_and_graphs;

public class LongestIncreasingPathInMatrix {

   private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

   public static void main(String[] args) {
      System.out.println(longestIncreasingPath(new int[][]{
         {9, 9, 4},
         {6, 6, 8},
         {2, 1, 1}
      }));

      System.out.println(longestIncreasingPath(new int[][]{
         {3, 4, 5},
         {3, 2, 6},
         {2, 2, 1}
      }));
   }

   private static int longestIncreasingPath(int[][] matrix) {
      int maxPath = 0;

      if (matrix == null || matrix.length == 0) {
         return maxPath;
      }

      int[][] memo = new int[matrix.length][matrix[0].length];
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[0].length; j++) {
            maxPath = Math.max(maxPath, dfs(matrix, i, j, memo));
         }
      }

      return maxPath;
   }

   private static int dfs(int[][] matrix, int i, int j, int[][] memo) {
      if (memo[i][j] != 0) {
         return memo[i][j];
      }

      for (int[] dir : dirs) {
         int x = i + dir[0];
         int y = j + dir[1];

         if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
            memo[i][j] = Math.max(memo[i][j], dfs(matrix, x, y, memo));
         }
      }
      // this one is tricky!!!
      return ++memo[i][j];
   }
}
