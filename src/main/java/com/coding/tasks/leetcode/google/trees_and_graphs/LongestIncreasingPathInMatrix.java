package com.coding.tasks.leetcode.google.trees_and_graphs;

public class LongestIncreasingPathInMatrix {

   private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
   private int m, n;

   // Time Limit. Cache is needed!!!!
   public static void main(String[] args) {
      LongestIncreasingPathInMatrix tm = new LongestIncreasingPathInMatrix();
      System.out.println(tm.longestIncreasingPath(new int[][]{
         {9, 9, 4},
         {6, 6, 8},
         {2, 1, 1}
      }));
   }

   public int longestIncreasingPath(int[][] matrix) {
      if (matrix.length == 0) {
         return 0;
      }

      int max = 0;
      m = matrix.length;
      n = matrix[0].length;

      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            max = Math.max(max, recursion(i, j, matrix));
         }
      }
      return max;
   }

   public int recursion(int i, int j, int[][] matrix) {
      int max = 0;

      for (int[] d : dirs) {
         int x = i + d[0], y = j + d[1];
         if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]) {
            max = Math.max(max, recursion(x, y, matrix));
         }
      }
      return ++max;
   }
}
