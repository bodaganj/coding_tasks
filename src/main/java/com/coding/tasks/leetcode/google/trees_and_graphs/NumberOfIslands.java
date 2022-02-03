package com.coding.tasks.leetcode.google.trees_and_graphs;

public class NumberOfIslands {

   private static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static void main(String[] args) {
      char[][] arr1 = new char[][]{
         {'1', '1', '1', '1', '0'},
         {'1', '1', '0', '1', '0'},
         {'1', '1', '0', '0', '0'},
         {'0', '0', '0', '0', '0'},
      };

      System.out.println(numIslands(arr1));
   }

   private static int numIslands(char[][] grid) {
      int amountOfIslands = 0;
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == '1') {
               amountOfIslands++;
               dfs(grid, i, j);
            }
         }
      }
      return amountOfIslands;
   }

   private static void dfs(char[][] grid, int i, int j) {
      int iLength = grid.length;
      int jLength = grid[0].length;
      if (i >= 0 && i < iLength && j >= 0 && j < jLength && grid[i][j] == '1') {
         grid[i][j] = '0';
         for (int[] direction : directions) {
            dfs(grid, i + direction[0], j + direction[1]);
         }
      }
   }
}
