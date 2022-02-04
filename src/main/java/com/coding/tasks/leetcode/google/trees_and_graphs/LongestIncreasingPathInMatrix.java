package com.coding.tasks.leetcode.google.trees_and_graphs;

public class LongestIncreasingPathInMatrix {

   private static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
   private static int m, n;

   public static void main(String[] args) {
//      System.out.println(longestIncreasingPath(new int[][]{
//         {9, 9, 4},
//         {6, 6, 8},
//         {2, 1, 1}
//      }));

      System.out.println(longestIncreasingPath(new int[][]{
         {3, 4, 5},
         {3, 2, 6},
         {2, 2, 1}
      }));
   }

   private static int longestIncreasingPath1(int[][] matrix) {
      int maxPath = 0;

      if (matrix == null || matrix.length == 0) {
         return maxPath;
      }

      int[][] memo = new int[matrix.length][matrix[0].length];
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[0].length; j++) {
            maxPath = Math.max(maxPath, dfs(matrix, i, j, null, memo));
         }
      }

      return maxPath;
   }

   private static int dfs(int[][] matrix, int i, int j, Integer prevValue, int[][] memo) {
      int path = 0;

      if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
         if (memo[i][j] != 0 && (prevValue != null && matrix[i][j] > prevValue)) {
            return memo[i][j];
         }

         if (prevValue == null || matrix[i][j] > prevValue) {
            for (int[] dir : dirs) {
               path = Math.max(path, 1 + dfs(matrix, i + dir[0], j + dir[1], matrix[i][j], memo));
            }
            memo[i][j] = path;
         }
      }

      return path;
   }

   private static int longestIncreasingPath(int[][] matrix) {
      if (matrix.length == 0) {
         return 0;
      }

      int max = 0;
      m = matrix.length;
      n = matrix[0].length;

      int[][] memo = new int[m][n];
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            max = Math.max(max, recursion(i, j, matrix, memo));
         }
      }
      return max;
   }

   private static int recursion(int i, int j, int[][] matrix, int[][] memo) {
      int max = 0;

      if (memo[i][j] != 0) {
         return memo[i][j];
      }

      for (int[] d : dirs) {
         int x = i + d[0], y = j + d[1];
         if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]) {
            max = Math.max(max, 1 + recursion(x, y, matrix, memo));
         }
      }

      memo[i][j] = max;
      return max;
   }
}
